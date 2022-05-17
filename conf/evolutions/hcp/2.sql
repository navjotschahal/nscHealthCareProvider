# --- !Ups

CREATE TABLE provider_services(
  id TEXT NOT NULL PRIMARY KEY,
  provider_id TEXT NOT NULL REFERENCES providers(id) ON DELETE CASCADE,
  provider_name TEXT NOT NULL,
  service_name TEXT NOT NULL,
  cost_near TEXT NOT NULL,
  estimated_total_cost TEXT NOT NULL,
  insurance_pays TEXT NOT NULL,
  estimated_out_of_pocket_cost TEXT NOT NULL,
  created_at timestamp default current_timestamp
);

INSERT INTO provider_services(id, provider_id, provider_name, service_name, cost_near, estimated_total_cost, insurance_pays, estimated_out_of_pocket_cost)
	VALUES ('85e8bace-063c-4f15-8da2-464f366e4a78',
	        '75e8bace-063c-4f15-8da2-464f366e4a78',
            'Bailey, Tanya J, MD',
            'Services Office Visit - Primary Doctor - Established Patient - High Complexity',
            '$302 - $377',
            'Below Average Cost',
            '* N/A',
            '* N/A');

INSERT INTO provider_services(id, provider_id, provider_name, service_name, cost_near, estimated_total_cost, insurance_pays, estimated_out_of_pocket_cost)
	VALUES ('85e8bace-063c-4f15-8da2-464f366e4a77',
	        '75e8bace-063c-4f15-8da2-464f366e4a77',
            'Meier, Diane M, MD',
            'Office Visit - Primary Doctor - Established Patient - Minimal Complexity',
            '$42 - $52',
            'Cost Not Available',
            '* N/A',
            '* N/A');

INSERT INTO provider_services(id, provider_id, provider_name, service_name, cost_near, estimated_total_cost, insurance_pays, estimated_out_of_pocket_cost)
	VALUES ('85e8bace-063c-4f15-8da2-464f366e4a76',
	        '75e8bace-063c-4f15-8da2-464f366e4a76',
            'Swan, Thomas T, MD',
            'Office Visit - Primary Doctor - Established Patient - Moderate Complexity',
            'C$145 - $188',
            'Below Average Cost',
            '* N/A',
            '* N/A');

# --- !Downs

drop table provider_services;
