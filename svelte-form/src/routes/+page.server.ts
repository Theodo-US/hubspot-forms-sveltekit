import { HUBSPOT_FORM_ID, HUBSPOT_PORTAL_ID, HUBSPOT_PRIVATE_APP_KEY } from '$env/static/private';
import { redirect } from '@sveltejs/kit';

export const csr = false;

interface FormFieldGroups {
  fields: {
    name: string;
    label: string;
    fieldType: string;
    options: { value: string; label: string }[];
    objectTypeId: string;
  }[];
}

export async function load() {
  const url = new URL(`https://api.hubapi.com/forms/v2/forms/${HUBSPOT_FORM_ID}`);
  const request = new Request(url, {
    method: 'GET',
    headers: {
      'cache-control': 'max-age=3600', // cache form response for 1 hour
      Authorization: `Bearer ${HUBSPOT_PRIVATE_APP_KEY}`
    }
  });

  const response = await fetch(request);
  const data: { formFieldGroups: FormFieldGroups[] } = await response.json();

  return data;
}

export const actions = {
  submit: async ({ request }) => {
    const data = await request.formData();
    const fields = [];

    for (const el of data) {
      fields.push({
        name: el[0],
        value: el[1],
        objectTypeId: '0-1'
      });
    }

    const result = await fetch(
      `https://api.hsforms.com/submissions/v3/integration/submit/${HUBSPOT_PORTAL_ID}/${HUBSPOT_FORM_ID}`,
      {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          Authorization: `Bearer ${HUBSPOT_PRIVATE_APP_KEY}`
        },
        body: JSON.stringify({ fields })
      }
    );

    if (result.status > 201) {
      throw redirect(302, '/error');
    } else {
      throw redirect(302, '/thank-you');
    }
  }
};
