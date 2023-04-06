const formSubmissionTest = async (page) => {
  await page.goto('https://share.hsforms.com/1JFQbjrblSeCcRLwUvqqLEAebia9');
  await page.getByLabel('String field').fill('Hubspot Form Performance Test');
  await page.getByLabel('Email field').fill('hubspot.test@theodo.com');
  await page.getByRole('combobox', { name: 'Dropdown field' }).selectOption('Alabama');
  await page.getByLabel('Open Deal').check();
  await page.getByText('techvisionary').click();
  await page.getByText('techinfluencer').click();
  await page.getByRole('button', { name: 'Submit' }).click();
  await page.getByText('Thanks for submitting the form.');
};

module.exports = {
  formSubmissionTest
};
