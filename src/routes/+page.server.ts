import { HUBSPOT_FORM_ID, HUBSPOT_PORTAL_ID, HUBSPOT_PRIVATE_APP_KEY } from '$env/static/private';

interface FormFieldGroups {
  fields: {
    name: string;
    label: string;
    fieldType: string;
    options: { value: string; label: string }[];
  }[];
}

export async function load() {
  const response = await fetch(`https://api.hubapi.com/forms/v2/forms/${HUBSPOT_FORM_ID}`, {
    method: 'GET',
    headers: {
      Authorization: `Bearer ${HUBSPOT_PRIVATE_APP_KEY}`
    }
  });
  const data: FormFieldGroups = await response.json();

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

    await fetch(
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

    return { success: true };
  }
};
