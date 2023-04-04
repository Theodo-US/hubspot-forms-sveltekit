import axios from 'axios';
import { HUBSPOT_FORM_ID, HUBSPOT_PRIVATE_APP_KEY } from '$env/static/private';

interface FormFieldGroups {
  fields: {
    name: string;
    label: string;
    type: string;
    fieldType: string;
    description: string;
    groupName: string;
    displayOrder: number;
    required: boolean;
    // selectedOptions: [];
    options: { value: string; label: string }[]; // Not sure
    // validation: [Object];
    enabled: boolean;
    hidden: boolean;
    defaultValue: string;
    isSmartField: boolean;
    unselectedLabel: string;
    placeholder: string;
    // dependentFieldFilters: [];
    labelHidden: boolean;
    propertyObjectType: string;
    // metaData: [];
    objectTypeId: string;
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
    // console.log(...data);

    // const fields = [];

    // for (const el of data) {
    // 	fields.push({
    // 		name: el[0],
    // 		value: el[1],
    // 		objectTypeId: '0-1'
    // 	});
    // }

    // console.log(`The body is ${JSON.stringify({ body: fields })}`);

    // UNTESTED
    // const response = await axios.post(
    // 	`https://api.hsforms.com/submissions/v3/integration/submit/${HUBSPOT_PORTAL_ID}/${HUBSPOT_FORM_ID}`,
    // 	{ body: fields },
    // 	{
    // 		headers: {
    // 			Authorization: `Bearer ${HUBSPOT_PRIVATE_APP_KEY}`
    // 		}
    // 	}
    // );

    // console.log(response);

    return { success: true };
  }
};
