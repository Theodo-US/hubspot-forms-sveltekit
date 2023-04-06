<script lang="ts">
  export let field: {name: string, label: string};
</script>

<label class="field-label" for={field.name}>{field.label}</label>

<style>
  .field-label {
    font-size:small;
    color: grey;
  }
</style>