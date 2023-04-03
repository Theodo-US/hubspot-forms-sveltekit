<script>
	/** @type {import('./$types').PageData} */
	export let data;
</script>

<h1>Get your refund</h1>
<form action="?/submit" method="POST">
	{#each data.formFieldGroups as group}
		<fieldset>
			{#each group.fields as field}
				<label for={field.name}>{field.label}</label>
				{#if field.fieldType === 'select'}
					<select name={field.name} id={field.name}>
						{#each field.options as option}
							<option value={option.value}>{option.label}</option>
						{/each}
					</select>
				{:else}
					<input type={field.fieldType} name={field.name} id={field.name} />
				{/if}
			{/each}
		</fieldset>
	{/each}
	<button type="submit">Submit</button>
</form>
