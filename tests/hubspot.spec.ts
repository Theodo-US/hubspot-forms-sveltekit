import { test } from '@playwright/test';

test.beforeEach(async ({ page }) => {
  await page.goto('https://share.hsforms.com/1JFQbjrblSeCcRLwUvqqLEAebia9');
});
