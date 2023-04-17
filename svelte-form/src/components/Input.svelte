<script lang="ts">
  import type { FormField } from '../routes/+page.server';

  export let field: FormField;
</script>

<input class="field-input" type={field.fieldType} name={field.name} id={field.name} />

<style>
  .field-input {
    margin-top: 2px;
    padding: 8px 16px;
    font-size: large;
  }
</style>
