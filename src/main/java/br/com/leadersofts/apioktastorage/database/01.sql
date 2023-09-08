-- CREATING TABLE ESTOQUE
CREATE TABLE estoque
(
    id              bigint not null
        primary key,
    data_entrada    date,
    dias_no_estoque bigint,
    dono            varchar(255),
    local_estoque   varchar(255),
    marca           varchar(255),
    media           real,
    origem          varchar(255),
    quantidade      bigint,
    status          varchar(255),
    observacao_id   bigint,
    constraint pk_obs PRIMARY KEY(id),
    constraint fk94otdqbqx6ssnwlglj8t8cvff foreign key (observacao_id)
        references observacao
);

ALTER TABLE estoque OWNER TO postgres;

-- CREATING TABLE VEICULO
CREATE TABLE veiculo
(
    id           bigint not null
        primary key,
    ano_modelo   varchar(255),
    cor          varchar(255),
    kilometragem real,
    marca        varchar(255),
    nome         varchar(255),
    opcionais    varchar(255),
    placa        varchar(255),
    constraint pk_veiculo PRIMARY KEY(id)
);

ALTER TABLE veiculo
    OWNER TO postgres;


-- CREATING TABLE OBSERVAÇÃO
CREATE TABLE observacao
(
    id            bigint not null
        primary key,
    funilaria     varchar(255),
    higienizacao  varchar(255),
    mecanica      varchar(255),
    obs_oficina   varchar(255),
    pintura       varchar(255),
    polimento     varchar(255),
    revisao       varchar(255),
    transferencia varchar(255),
    constraint pk_obs PRIMARY KEY(id)

);

ALTER TABLE observacao
    OWNER TO postgres;

-- RELATIONSHIP TABLES
CREATE TABLE estoque_veiculos
(
    estoque_id  bigint not null
        constraint fk6v3syr3uuc77uk8lh41g68ny7
            references estoque,
    veiculos_id bigint not null
        constraint uk_to3jevy4s234xh7y1a7qvq7hx
            unique
        constraint fk72wccadvwrc03shva92belpbq
            references veiculo
);

ALTER TABLE estoque_veiculos
    OWNER TO postgres;