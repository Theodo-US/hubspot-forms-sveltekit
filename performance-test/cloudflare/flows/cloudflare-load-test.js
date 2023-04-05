const formSubmissionTest = async (page) => {
  await page.goto('https://hubspot-forms-sveltekit.pages.dev/');
  await page.getByLabel('String field').fill('Test String');
  await page.getByLabel('Email field').fill('test@theodo.com');
  await page.getByLabel('Dropdown field').selectOption('Alabama');
  await page.getByLabel('New').check();
  await page.getByLabel('ex-entrepreneur').check();
  await page.getByLabel('cto').check();
  await page.getByText('Submit').click();
  await page.getByText('Thank you for submitting the form');
};

module.exports = {
  formSubmissionTest,
};
