BEGIN;

CREATE TABLE IF NOT EXISTS public."APPENDIXA_BATCH"
(
    abt_id uuid NOT NULL,
    abt_batch_id character(22)[],
    abt_request_id character varying(18),
    abt_processing_status character varying(3),
    abt_output_file_reference text,
    abt_category character varying(20) COLLATE pg_catalog."default",
    abt_subcategory character varying(20) COLLATE pg_catalog."default",
    abt_output_count integer,
    arq_start_timestamp timestamp with time zone,
    arq_end_timestamp timestamp with time zone,
    arq_created_by character varying(30) COLLATE pg_catalog."default",
    arq_modified_by character varying(30) COLLATE pg_catalog."default",
    arq_created_timestamp timestamp with time zone,
    arq_modified_timestamp timestamp with time zone,
    CONSTRAINT abt_id_pk PRIMARY KEY (abt_id),
    CONSTRAINT abt_batch_id_unique UNIQUE (abt_batch_id)
);

CREATE TABLE IF NOT EXISTS public."APPENDIXA_REQUEST"
(
    arq_id uuid NOT NULL,
    arq_request_id character varying(18) COLLATE pg_catalog."default",
    arq_request_type character varying(3),
    arq_processing_status character varying(3),
    arq_start_timestamp timestamp with time zone,
    arq_end_timestamp timestamp with time zone,
    arq_created_by character varying(30) COLLATE pg_catalog."default",
    arq_modified_by character varying(30) COLLATE pg_catalog."default",
    arq_created_timestamp timestamp with time zone,
    arq_modified_timestamp timestamp with time zone,
    arq_notification_sent boolean,
    arq_request_source character varying(3),
    CONSTRAINT arq_id_pk PRIMARY KEY (arq_id),
    CONSTRAINT "arq-request_id_unique" UNIQUE (arq_request_id)
);

CREATE TABLE IF NOT EXISTS public."APPENDIXA_PROCESSING_STATUS"
(
    aps_id uuid NOT NULL,
    aps_processing_status_code character varying(3) COLLATE pg_catalog."default",
    aps_processing_name character varying(30) COLLATE pg_catalog."default",
    CONSTRAINT aps_id_pk PRIMARY KEY (aps_id),
    CONSTRAINT aps_processing_status_code UNIQUE (aps_processing_status_code)
        INCLUDE(aps_processing_status_code)
);

CREATE TABLE IF NOT EXISTS public."APPENDIXA_REQUEST_TYPE"
(
    art_id uuid NOT NULL,
    art_request_type_code character varying(3) COLLATE pg_catalog."default",
    art_request_type_description character varying(30) COLLATE pg_catalog."default",
    CONSTRAINT art_id_pk PRIMARY KEY (art_id),
    CONSTRAINT art_req_type_uniq UNIQUE (art_request_type_code)
);

CREATE TABLE IF NOT EXISTS public."APPENDIXA_REQUEST_SOURCE"
(
    ars_id uuid NOT NULL,
    ars_request_source character varying(3) COLLATE pg_catalog."default",
    ars_request_source_description character varying(30) COLLATE pg_catalog."default",
    CONSTRAINT ars_id_pk PRIMARY KEY (ars_id),
    CONSTRAINT ars_req_src_uniq UNIQUE (ars_request_source)
);

CREATE TABLE IF NOT EXISTS public."APPENDIXA_REQUEST_PARAMETERS"
(
    arp_id uuid NOT NULL,
    arp_request_id character varying(18),
    arp_input_parameters json NOT NULL,
    abp_category character varying COLLATE pg_catalog."default",
    abp_subcategory character varying COLLATE pg_catalog."default",
    abp_product_count integer,
    abp_created_by character varying(30) COLLATE pg_catalog."default",
    abp_modified_by character varying(30) COLLATE pg_catalog."default",
    abp_created_timestamp timestamp with time zone,
    abp_modified_timestamp timestamp with time zone,
    CONSTRAINT abp_id_pk PRIMARY KEY (arp_id)
);

ALTER TABLE IF EXISTS public."APPENDIXA_BATCH"
    ADD CONSTRAINT appendix_batch_request_id_fk FOREIGN KEY (abt_request_id)
        REFERENCES public."APPENDIXA_REQUEST" (arq_request_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID;


ALTER TABLE IF EXISTS public."APPENDIXA_BATCH"
    ADD CONSTRAINT appendixa_processing_status_fk FOREIGN KEY (abt_processing_status)
        REFERENCES public."APPENDIXA_REQUEST" (arq_request_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID;


ALTER TABLE IF EXISTS public."APPENDIXA_REQUEST"
    ADD CONSTRAINT appendixa_request_type_fk FOREIGN KEY (arq_request_type)
        REFERENCES public."APPENDIXA_REQUEST_TYPE" (art_request_type_code) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID;


ALTER TABLE IF EXISTS public."APPENDIXA_REQUEST"
    ADD CONSTRAINT arq_processing_status_fk FOREIGN KEY (arq_processing_status)
        REFERENCES public."APPENDIXA_PROCESSING_STATUS" (aps_processing_status_code) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID;


ALTER TABLE IF EXISTS public."APPENDIXA_REQUEST"
    ADD CONSTRAINT arq_request_source_fk FOREIGN KEY (arq_request_source)
        REFERENCES public."APPENDIXA_REQUEST_SOURCE" (ars_request_source) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID;


ALTER TABLE IF EXISTS public."APPENDIXA_REQUEST_PARAMETERS"
    ADD CONSTRAINT arp_fk FOREIGN KEY (arp_request_id)
        REFERENCES public."APPENDIXA_REQUEST" (arq_request_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID;

END;