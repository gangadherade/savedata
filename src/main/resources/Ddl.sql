DROP TABLE IF EXISTS public."APPENDIXA_REQUEST_TEST";

CREATE TABLE IF NOT EXISTS public."APPENDIXA_REQUEST_TEST"
(
    arq_id uuid,
    category character varying,
    subcategory character varying,
    arq_processing_status character varying,
    arq_start_timestamp timestamp with time zone,
    arq_end_timestamp timestamp with time zone,
    arq_created_by character varying,
    arq_modified_by character varying,
    arq_created_timestamp timestamp with time zone,
    arq_modified_timestamp timestamp with time zone,
    stn character varying,
    CONSTRAINT arq_id_pk2 PRIMARY KEY (arq_id)
);

Commit;
INSERT INTO public."APPENDIXA_PROCESSING_STATUS"(aps_id,
                                                 aps_processing_status_code, aps_processing_status_name)
VALUES ( UUID_GENERATE_V4(),'COMPLETED', 'completed');