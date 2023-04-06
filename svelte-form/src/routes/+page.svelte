<script>
	import FieldLabel from './../components/FieldLabel.svelte';
  import GroupedInput from '../components/GroupedInput.svelte';
  import SelectInput from '../components/SelectInput.svelte';
  import Input from '../components/Input.svelte';
  import Submit from '../components/Submit.svelte';
  import Paper from '../components/Paper.svelte';
  import FieldSet from '../components/FieldSet.svelte';

  /** @type {import('./$types').PageData} */
  export let data;
</script>

<Paper>
  <h1 class="form-header">Simple Performance Form</h1>
  <form class="form-body" action="?/submit" method="POST">
    {#each data.formFieldGroups as group}
      <FieldSet>
        {#each group.fields as field}
          <FieldLabel {field}/>
          {#if field.fieldType === 'select'}
            <SelectInput {field}/>
          {:else if field.fieldType === 'radio' || field.fieldType === 'checkbox'}          
            <GroupedInput {field}/>      
          {:else}
            <Input {field}/>
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