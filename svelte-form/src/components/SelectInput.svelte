<script lang="ts">
  export let field: {
    name: string;
    options: {
      value: string;
      label: string;
    }[]
  };
</script>

<select class="select-input" name={field.name} id={field.name}>
  {#each field.options as option}
    <option value={option.value}>{option.label}</option>
  {/each}
</select>

<style>
  .select-input {
    margin-top: 2px;
    padding: 8px 16px;
    font-size: large;
  }
</style>