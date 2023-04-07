<script lang="ts">
  import FieldLabel from './../components/FieldLabel.svelte';
  import GroupedInput from '../components/GroupedInput.svelte';
  import SelectInput from '../components/SelectInput.svelte';
  import Input from '../components/Input.svelte';
  import Submit from '../components/Submit.svelte';
  import Paper from '../components/Paper.svelte';
  import FieldSet from '../components/FieldSet.svelte';
  import type { PageData } from './$types';

  export let data: PageData;

  async function handleSubmit(event: SubmitEvent) {
    const formElement = event.target as HTMLFormElement;
    if (!formElement) return;
    const formData = new FormData(formElement);

    for (let [key, value] of formData.entries()) {
      let formTypeId;
      const originalFormField = data.formFieldGroups.find((group) =>
        group.fields.find((field) => {
          if (field.name === key) {
            formTypeId = field.objectTypeId;
            return true;
          }
        })
      );
      formData.set(key, JSON.stringify({ value: value as string, typeId: formTypeId || '' }));
    }

    await fetch('?/submit', {
      method: 'POST',
      redirect: 'follow',
      body: formData
    });
  }
</script>

<Paper>
  <h1 class="form-header">Simple Performance Form</h1>
  <form class="form-body" on:submit|preventDefault={handleSubmit}>
    {#each data.formFieldGroups as group}
      <FieldSet>
        {#each group.fields as field}
          <FieldLabel {field} />
          {#if field.fieldType === 'select'}
            <SelectInput {field} />
          {:else if field.fieldType === 'radio' || field.fieldType === 'checkbox'}
            <GroupedInput {field} />
          {:else}
            <Input {field} />
          {/if}
        {/each}
      </FieldSet>
    {/each}
    <Submit />
  </form>
</Paper>

<style>
  .form-header {
    text-align: center;
  }
</style>
