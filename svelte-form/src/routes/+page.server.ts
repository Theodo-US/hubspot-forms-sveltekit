import { HUBSPOT_FORM_ID, HUBSPOT_PORTAL_ID, HUBSPOT_PRIVATE_APP_KEY } from '$env/static/private';

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
  const response = await fetch(`https://api.hubapi.com/forms/v2/forms/${HUBSPOT_FORM_ID}`, {
    method: 'GET',
    headers: {
      'Cache-Control': 'max-age=3600', // cache form response for 1 hour
      Authorization: `Bearer ${HUBSPOT_PRIVATE_APP_KEY}`
    }
  });
  const data: { formFieldGroups: FormFieldGroups[] } = await response.json();
  return data;
}

export const actions = {
  submit: async (event) => {
    const data = await event.request.formData();
    const fields = [];

    for (const el of data) {
      console.info(el[0]);
      fields.push({
        name: el[0],
        value: el[1],
        objectTypeId: el[0] === 'industry' ? '0-2' : '0-1'
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
