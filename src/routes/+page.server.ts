import axios from 'axios';
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
  const response = await axios.get<{ formFieldGroups: FormFieldGroups[] }>(
    `https://api.hubapi.com/forms/v2/forms/${HUBSPOT_FORM_ID}`,
    {
      headers: {
        Authorization: `Bearer ${HUBSPOT_PRIVATE_APP_KEY}`
      }
    }
  );
  return { formFieldGroups: response.data.formFieldGroups };
}

export const actions = {
  submit: async ({ request }) => {
    const data = await request.formData();
    console.log(data);

    const fields = [];

    for (const el of data) {
      fields.push({
        name: el[0],
        value: el[1],
        objectTypeId: '0-1'
      });
    }

    await axios.post(
      `https://api.hsforms.com/submissions/v3/integration/submit/${HUBSPOT_PORTAL_ID}/${HUBSPOT_FORM_ID}`,
      { fields },
      {
        headers: {
          Authorization: `Bearer ${HUBSPOT_PRIVATE_APP_KEY}`
        }
      }
    );

    return { success: true };
  }
};
