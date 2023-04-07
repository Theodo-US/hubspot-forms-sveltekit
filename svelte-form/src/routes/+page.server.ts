import { HUBSPOT_FORM_ID, HUBSPOT_PORTAL_ID, HUBSPOT_PRIVATE_APP_KEY } from '$env/static/private';
import { redirect } from '@sveltejs/kit';

export interface FormField {
  name: string;
  label: string;
  fieldType: string;
  options: { value: string; label: string }[];
  objectTypeId: string;
}
export interface FormFieldGroup {
  fields: FormField[];
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
  const data: { formFieldGroups: FormFieldGroup[] } = await response.json();

  return data;
}

export const actions = {
  submit: async ({ request }) => {
    const data = await request.formData();
    const fields = [];

    for (const [key, value] of data) {
      const values = JSON.parse(value as string);
      fields.push({
        name: key,
        value: values.value,
        objectTypeId: values.typeId
      });
    }
    console.log(fields);
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
    }

    throw redirect(302, '/thank-you');
  }
};
