<script lang="ts">
  export let field: {
    name: string;
    fieldType: string;
    options: {
      value: string;
      label: string;
    }[]
  };
</script>

{#each field.options as option}      
  <div class="grouped-input">    
    <input
      type={field.fieldType}
      name={field.name}
      id={option.value}
      value={option.value}
    />
    <label class="grouped-input-label" for={option.value}>{option.label}</label>
  </div>
{/each}

<style>
  .grouped-input {
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: left;
    margin-top: 4px;
  }
  .grouped-input-label {
    margin-left:8px;
  }
</style>