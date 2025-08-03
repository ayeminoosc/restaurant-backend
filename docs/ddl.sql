create table public.cooking_instruction
(
    id          serial
        primary key,
    description varchar(60)
);

alter table public.cooking_instruction
    owner to appuser95;

create table public.coupon_and_discount
(
    id                 serial
        primary key,
    name               varchar(120),
    type               integer,
    barcode            varchar(120),
    qualification_type integer,
    apply_to_all       boolean,
    minimum_buy        integer,
    maximum_off        integer,
    value              double precision,
    expiry_date        timestamp,
    enabled            boolean,
    auto_apply         boolean,
    modifiable         boolean,
    never_expire       boolean,
    uuid               varchar(36)
        unique
);

alter table public.coupon_and_discount
    owner to appuser95;

create table public.currency
(
    id             serial
        primary key,
    code           varchar(20),
    name           varchar(30),
    symbol         varchar(10),
    exchange_rate  double precision,
    decimal_places integer,
    tolerance      double precision,
    buy_price      double precision,
    sales_price    double precision,
    main           boolean
);

alter table public.currency
    owner to appuser95;

create table public.customer
(
    auto_id                serial
        primary key,
    loyalty_no             varchar(30),
    loyalty_point          integer,
    social_security_number varchar(60),
    picture                bytea,
    homephone_no           varchar(30),
    mobile_no              varchar(30),
    workphone_no           varchar(30),
    email                  varchar(40),
    salutation             varchar(60),
    first_name             varchar(60),
    last_name              varchar(60),
    name                   varchar(120),
    dob                    varchar(16),
    ssn                    varchar(30),
    address                varchar(220),
    city                   varchar(30),
    state                  varchar(30),
    zip_code               varchar(10),
    country                varchar(30),
    vip                    boolean,
    credit_limit           double precision,
    credit_spent           double precision,
    credit_card_no         varchar(30),
    note                   varchar(255)
);

alter table public.customer
    owner to appuser95;

create table public.customer_properties
(
    id             integer      not null
        constraint fkd43068347bbccf0
            references public.customer,
    property_value varchar(255),
    property_name  varchar(255) not null,
    primary key (id, property_name)
);

alter table public.customer_properties
    owner to appuser95;

create table public.custom_payment
(
    id                    serial
        primary key,
    name                  varchar(60),
    required_ref_number   boolean,
    ref_number_field_name varchar(60)
);

alter table public.custom_payment
    owner to appuser95;

create table public.data_update_info
(
    id               serial
        primary key,
    last_update_time timestamp
);

alter table public.data_update_info
    owner to appuser95;

create table public.delivery_address
(
    id              serial
        primary key,
    address         varchar(320),
    phone_extension varchar(10),
    room_no         varchar(30),
    distance        double precision,
    customer_id     integer
        constraint fk29aca6899e1c3cf1
            references public.customer
);

alter table public.delivery_address
    owner to appuser95;

create table public.delivery_charge
(
    id            serial
        primary key,
    name          varchar(220),
    zip_code      varchar(20),
    start_range   double precision,
    end_range     double precision,
    charge_amount double precision
);

alter table public.delivery_charge
    owner to appuser95;

create table public.delivery_configuration
(
    id                 serial
        primary key,
    unit_name          varchar(20),
    unit_symbol        varchar(8),
    charge_by_zip_code boolean
);

alter table public.delivery_configuration
    owner to appuser95;

create table public.delivery_instruction
(
    id          serial
        primary key,
    notes       varchar(220),
    customer_no integer
        constraint fk29d9ca39e1c3d97
            references public.customer
);

alter table public.delivery_instruction
    owner to appuser95;

create table public.global_config
(
    id        serial
        primary key,
    pos_key   varchar(60)
        unique,
    pos_value varchar(220)
);

alter table public.global_config
    owner to appuser95;

create table public.inventory_group
(
    id      serial
        primary key,
    name    varchar(60) not null,
    visible boolean
);

alter table public.inventory_group
    owner to appuser95;

create table public.inventory_meta_code
(
    id          serial
        primary key,
    type        varchar(255),
    code_text   varchar(255),
    code_no     integer,
    description varchar(255)
);

alter table public.inventory_meta_code
    owner to appuser95;

create table public.inventory_unit
(
    id           serial
        primary key,
    short_name   varchar(255),
    long_name    varchar(255),
    alt_name     varchar(255),
    conv_factor1 varchar(255),
    conv_factor2 varchar(255),
    conv_factor3 varchar(255)
);

alter table public.inventory_unit
    owner to appuser95;

create table public.inventory_vendor
(
    id      serial
        primary key,
    name    varchar(60)  not null,
    visible boolean,
    address varchar(120) not null,
    city    varchar(60)  not null,
    state   varchar(60)  not null,
    zip     varchar(60)  not null,
    country varchar(60)  not null,
    email   varchar(60)  not null,
    phone   varchar(60)  not null,
    fax     varchar(60)
);

alter table public.inventory_vendor
    owner to appuser95;

create table public.inventory_warehouse
(
    id      serial
        primary key,
    name    varchar(60) not null,
    visible boolean
);

alter table public.inventory_warehouse
    owner to appuser95;

create table public.inventory_location
(
    id           serial
        primary key,
    name         varchar(60) not null,
    sort_order   integer,
    visible      boolean,
    warehouse_id integer
        constraint fk59073b58c46a9c15
            references public.inventory_warehouse
);

alter table public.inventory_location
    owner to appuser95;

create table public.menu_category
(
    id              serial
        primary key,
    name            varchar(120) not null,
    translated_name varchar(120),
    visible         boolean,
    beverage        boolean,
    sort_order      integer,
    btn_color       integer,
    text_color      integer
);

alter table public.menu_category
    owner to appuser95;

create table public.menucategory_discount
(
    discount_id     integer not null
        constraint fk4f8523e3d3e91e11
            references public.coupon_and_discount,
    menucategory_id integer not null
        constraint fk4f8523e38d9ea931
            references public.menu_category
);

alter table public.menucategory_discount
    owner to appuser95;

create index food_category_visible
    on public.menu_category (visible);

create table public.menu_group
(
    id              serial
        primary key,
    name            varchar(120) not null,
    translated_name varchar(120),
    visible         boolean,
    sort_order      integer,
    btn_color       integer,
    text_color      integer,
    category_id     integer
        constraint fk4dc1ab7f2e347ff0
            references public.menu_category
);

alter table public.menu_group
    owner to appuser95;

create table public.menugroup_discount
(
    discount_id  integer not null
        constraint fke3790e40d3e91e11
            references public.coupon_and_discount,
    menugroup_id integer not null
        constraint fke3790e40113bf083
            references public.menu_group
);

alter table public.menugroup_discount
    owner to appuser95;

create index menugroupvisible
    on public.menu_group (visible);

create table public.menu_item_size
(
    id              serial
        primary key,
    name            varchar(60),
    translated_name varchar(60),
    description     varchar(120),
    sort_order      integer,
    size_in_inch    double precision,
    default_size    boolean
);

alter table public.menu_item_size
    owner to appuser95;

create table public.menu_modifier_group
(
    id              serial
        primary key,
    name            varchar(60),
    translated_name varchar(60),
    enabled         boolean,
    exclusived      boolean,
    required        boolean
);

alter table public.menu_modifier_group
    owner to appuser95;

create index mg_enable
    on public.menu_modifier_group (enabled);

create table public.multiplier
(
    name               varchar(20) not null
        primary key,
    ticket_prefix      varchar(20),
    rate               double precision,
    sort_order         integer,
    default_multiplier boolean,
    main               boolean,
    btn_color          integer,
    text_color         integer
);

alter table public.multiplier
    owner to appuser95;

create table public.online_order
(
    id               varchar(128) not null
        primary key,
    version_no       bigint       not null,
    last_update_time timestamp,
    last_sync_time   timestamp,
    order_date       timestamp,
    cust_id          varchar(128),
    store_id         varchar(128),
    store_schema     varchar(128),
    store_name       varchar(128),
    outlet_id        varchar(128),
    ticket_id        varchar(128),
    order_type       varchar(128),
    order_status     varchar(128),
    paid             boolean,
    settled          boolean,
    expiry_date      timestamp,
    source           varchar(128),
    ticket_json      text,
    properties       text
);

alter table public.online_order
    owner to appuser95;

create table public.order_type
(
    id                             serial
        primary key,
    name                           varchar(120) not null
        unique,
    enabled                        boolean,
    show_table_selection           boolean,
    show_guest_selection           boolean,
    should_print_to_kitchen        boolean,
    prepaid                        boolean,
    close_on_paid                  boolean,
    required_customer_data         boolean,
    delivery                       boolean,
    show_item_barcode              boolean,
    show_in_login_screen           boolean,
    consolidate_tiems_in_receipt   boolean,
    allow_seat_based_order         boolean,
    hide_item_with_empty_inventory boolean,
    has_forhere_and_togo           boolean,
    pre_auth_credit_card           boolean,
    bar_tab                        boolean,
    retail_order                   boolean,
    show_price_on_button           boolean,
    show_stock_count_on_button     boolean,
    show_unit_price_in_ticket_grid boolean,
    properties                     text
);

alter table public.order_type
    owner to appuser95;

create table public.packaging_unit
(
    id         serial
        primary key,
    name       varchar(30)
        unique,
    short_name varchar(10),
    factor     double precision,
    baseunit   boolean,
    dimension  varchar(30)
);

alter table public.packaging_unit
    owner to appuser95;

create table public.inventory_item
(
    id                      serial
        primary key,
    create_time             timestamp,
    last_update_date        timestamp,
    name                    varchar(60),
    package_barcode         varchar(30),
    unit_barcode            varchar(30),
    unit_per_package        double precision,
    sort_order              integer,
    package_reorder_level   integer,
    package_replenish_level integer,
    description             varchar(255),
    average_package_price   double precision,
    total_unit_packages     double precision,
    total_recepie_units     double precision,
    unit_purchase_price     double precision,
    unit_selling_price      double precision,
    visible                 boolean,
    punit_id                integer
        constraint fk7dc968363525e956
            references public.packaging_unit,
    recipe_unit_id          integer
        constraint fk7dc968366848d615
            references public.packaging_unit,
    item_group_id           integer
        constraint fk7dc968362cd583c1
            references public.inventory_group,
    item_location_id        integer
        constraint fk7dc9683695e455d3
            references public.inventory_location,
    item_vendor_id          integer
        constraint fk7dc968369e60c333
            references public.inventory_vendor
);

alter table public.inventory_item
    owner to appuser95;

create table public.payout_reasons
(
    id     serial
        primary key,
    reason varchar(255)
);

alter table public.payout_reasons
    owner to appuser95;

create table public.payout_recepients
(
    id   serial
        primary key,
    name varchar(255)
);

alter table public.payout_recepients
    owner to appuser95;

create table public.pizza_crust
(
    id              serial
        primary key,
    name            varchar(60),
    translated_name varchar(60),
    description     varchar(120),
    sort_order      integer,
    default_crust   boolean
);

alter table public.pizza_crust
    owner to appuser95;

create table public.pizza_modifier_price
(
    id        serial
        primary key,
    item_size integer
        constraint fkd3de7e7896183657
            references public.menu_item_size
);

alter table public.pizza_modifier_price
    owner to appuser95;

create table public.pizza_price
(
    id             serial
        primary key,
    price          double precision,
    menu_item_size integer
        constraint fkeac11292dd545b77
            references public.menu_item_size,
    crust          integer
        constraint fkeac112927c59441d
            references public.pizza_crust,
    order_type     integer
        constraint fkeac11292a56d141c
            references public.order_type
);

alter table public.pizza_price
    owner to appuser95;

create table public.printer_configuration
(
    id              integer not null
        primary key,
    receipt_printer varchar(255),
    kitchen_printer varchar(255),
    prwts           boolean,
    prwtp           boolean,
    pkwts           boolean,
    pkwtp           boolean,
    unpft           boolean,
    unpfk           boolean
);

alter table public.printer_configuration
    owner to appuser95;

create table public.printer_group
(
    id         serial
        primary key,
    name       varchar(60) not null
        unique,
    is_default boolean
);

alter table public.printer_group
    owner to appuser95;

create table public.kitchen_ticket
(
    id              serial
        primary key,
    ticket_id       integer,
    create_date     timestamp,
    close_date      timestamp,
    voided          boolean,
    sequence_number integer,
    status          varchar(30),
    server_name     varchar(30),
    ticket_type     varchar(20),
    pg_id           integer
        constraint fk341cbc275cf1375f
            references public.printer_group
);

alter table public.kitchen_ticket
    owner to appuser95;

create table public.kitchen_ticket_item
(
    id                      serial
        primary key,
    cookable                boolean,
    ticket_item_id          integer,
    ticket_item_modifier_id integer,
    menu_item_code          varchar(255),
    menu_item_name          varchar(120),
    menu_item_group_id      integer,
    menu_item_group_name    varchar(120),
    quantity                integer,
    fractional_quantity     double precision,
    fractional_unit         boolean,
    unit_name               varchar(20),
    sort_order              integer,
    voided                  boolean,
    status                  varchar(30),
    kithen_ticket_id        integer
        constraint fk1462f02bcb07faa3
            references public.kitchen_ticket,
    item_order              integer
);

alter table public.kitchen_ticket_item
    owner to appuser95;

create table public.kit_ticket_table_num
(
    kit_ticket_id integer not null
        constraint fk5696584bb73e273e
            references public.kitchen_ticket,
    table_id      integer
);

alter table public.kit_ticket_table_num
    owner to appuser95;

create table public.printer_group_printers
(
    printer_id   integer not null
        constraint fkc05b805e5f31265c
            references public.printer_group,
    printer_name varchar(255)
);

alter table public.printer_group_printers
    owner to appuser95;

create table public.purchase_order
(
    id       serial
        primary key,
    order_id varchar(30),
    name     varchar(30)
);

alter table public.purchase_order
    owner to appuser95;

create table public.inventory_transaction
(
    id                serial
        primary key,
    transaction_date  timestamp,
    unit_quantity     double precision,
    unit_price        double precision,
    remark            varchar(255),
    tran_type         integer,
    reference_id      integer
        constraint fkaf48f43b5b397c5
            references public.purchase_order,
    item_id           integer
        constraint fkaf48f43b96a3d6bf
            references public.inventory_item,
    vendor_id         integer
        constraint fkaf48f43bd152c95f
            references public.inventory_vendor,
    from_warehouse_id integer
        constraint fkaf48f43bff3f328a
            references public.inventory_warehouse,
    to_warehouse_id   integer
        constraint fkaf48f43beda09759
            references public.inventory_warehouse
);

alter table public.inventory_transaction
    owner to appuser95;

create table public.restaurant
(
    id                        integer not null
        primary key,
    unique_id                 integer,
    uuid                      varchar(128),
    name                      varchar(120),
    address_line1             varchar(60),
    address_line2             varchar(60),
    address_line3             varchar(60),
    zip_code                  varchar(10),
    telephone                 varchar(16),
    capacity                  integer,
    tables                    integer,
    cname                     varchar(20),
    csymbol                   varchar(10),
    sc_percentage             double precision,
    gratuity_percentage       double precision,
    ticket_footer             varchar(60),
    price_includes_tax        boolean,
    allow_modifier_max_exceed boolean
);

alter table public.restaurant
    owner to appuser95;

create table public.restaurant_properties
(
    id             integer      not null
        constraint fk80ad9f75fc64768f
            references public.restaurant,
    property_value varchar(1000),
    property_name  varchar(255) not null,
    primary key (id, property_name)
);

alter table public.restaurant_properties
    owner to appuser95;

create table public.shift
(
    id         serial
        primary key,
    name       varchar(60) not null
        unique,
    start_time timestamp,
    end_time   timestamp,
    shift_len  bigint
);

alter table public.shift
    owner to appuser95;

create table public.shop_floor
(
    id       serial
        primary key,
    name     varchar(60),
    occupied boolean,
    image    oid
);

alter table public.shop_floor
    owner to appuser95;

create table public.shop_floor_template
(
    id            serial
        primary key,
    name          varchar(60),
    default_floor boolean,
    main          boolean,
    floor_id      integer
        constraint fkba6efbd68979c3cd
            references public.shop_floor
);

alter table public.shop_floor_template
    owner to appuser95;

create table public.shop_floor_template_properties
(
    id             integer      not null
        constraint fkd70c313ca36ab054
            references public.shop_floor_template,
    property_value varchar(60),
    property_name  varchar(255) not null,
    primary key (id, property_name)
);

alter table public.shop_floor_template_properties
    owner to appuser95;

create table public.shop_table
(
    id          integer not null
        primary key,
    name        varchar(20),
    description varchar(60),
    capacity    integer,
    x           integer,
    y           integer,
    floor_id    integer
        constraint fk2458e9258979c3cd
            references public.shop_floor
);

alter table public.shop_table
    owner to appuser95;

create table public.shop_table_status
(
    id           integer not null
        primary key,
    table_status integer
);

alter table public.shop_table_status
    owner to appuser95;

create table public.shop_table_type
(
    id          serial
        primary key,
    description varchar(120),
    name        varchar(40)
);

alter table public.shop_table_type
    owner to appuser95;

create table public.table_ticket_num
(
    shop_table_status_id integer not null
        constraint fkcbeff0e454031ec1
            references public.shop_table_status,
    ticket_id            integer,
    user_id              integer,
    user_name            varchar(30)
);

alter table public.table_ticket_num
    owner to appuser95;

create table public.table_type_relation
(
    table_id integer not null
        constraint fk93802290dc46948d
            references public.shop_table,
    type_id  integer not null
        constraint fk93802290f5d6e47b
            references public.shop_table_type
);

alter table public.table_type_relation
    owner to appuser95;

create table public.tax
(
    id   serial
        primary key,
    name varchar(20) not null,
    rate double precision
);

alter table public.tax
    owner to appuser95;

create table public.menu_modifier
(
    id                   serial
        primary key,
    name                 varchar(120),
    translated_name      varchar(120),
    price                double precision,
    extra_price          double precision,
    sort_order           integer,
    btn_color            integer,
    text_color           integer,
    enable               boolean,
    fixed_price          boolean,
    print_to_kitchen     boolean,
    section_wise_pricing boolean,
    pizza_modifier       boolean,
    group_id             integer
        constraint fk59b6b1b72501cb2c
            references public.menu_modifier_group,
    tax_id               integer
        constraint fk59b6b1b7a4802f83
            references public.tax
);

alter table public.menu_modifier
    owner to appuser95;

create table public.menumodifier_pizzamodifierprice
(
    menumodifier_id       integer not null
        constraint fk572726f3ae3f2e91
            references public.menu_modifier,
    pizzamodifierprice_id integer not null
        constraint fk572726f374be2c71
            references public.pizza_modifier_price
);

alter table public.menumodifier_pizzamodifierprice
    owner to appuser95;

create index modifierenabled
    on public.menu_modifier (enable);

create table public.menu_modifier_properties
(
    menu_modifier_id integer      not null
        constraint fk1273b4bbb79c6270
            references public.menu_modifier,
    property_value   varchar(100),
    property_name    varchar(255) not null,
    primary key (menu_modifier_id, property_name)
);

alter table public.menu_modifier_properties
    owner to appuser95;

create table public.modifier_multiplier_price
(
    id                      serial
        primary key,
    price                   double precision,
    multiplier_id           varchar(20)
        constraint fk8a16099391d62c51
            references public.multiplier,
    menumodifier_id         integer
        constraint fk8a160993ae3f2e91
            references public.menu_modifier,
    pizza_modifier_price_id integer
        constraint fk8a1609939c9e4883
            references public.pizza_modifier_price
);

alter table public.modifier_multiplier_price
    owner to appuser95;

create table public.tax_group
(
    id   varchar(128) not null
        primary key,
    name varchar(20)  not null
);

alter table public.tax_group
    owner to appuser95;

create table public.group_taxes
(
    group_id varchar(128) not null
        constraint fkf8a37399eff11066
            references public.tax_group,
    elt      integer      not null
        constraint fkf8a37399d900aa01
            references public.tax
);

alter table public.group_taxes
    owner to appuser95;

create table public.menu_item
(
    id                                serial
        primary key,
    name                              varchar(120)     not null,
    description                       varchar(255),
    unit_name                         varchar(20),
    translated_name                   varchar(120),
    barcode                           varchar(120),
    buy_price                         double precision not null,
    stock_amount                      double precision,
    price                             double precision not null,
    discount_rate                     double precision,
    visible                           boolean,
    disable_when_stock_amount_is_zero boolean,
    sort_order                        integer,
    btn_color                         integer,
    text_color                        integer,
    image                             bytea,
    show_image_only                   boolean,
    fractional_unit                   boolean,
    pizza_type                        boolean,
    is_beverage                       boolean,
    default_sell_portion              integer,
    group_id                          integer
        constraint fk4cd5a1f35188aa24
            references public.menu_group,
    tax_group_id                      varchar(128)
        constraint fk4cd5a1f35ee9f27a
            references public.tax_group,
    recepie                           integer,
    inventory_item_id                 integer
        constraint fk_menu_item_inventory_item
            references public.inventory_item,
    pg_id                             integer
        constraint fk4cd5a1f35cf1375f
            references public.printer_group
);

alter table public.menu_item
    owner to appuser95;

create table public.item_order_type
(
    menu_item_id  integer not null
        constraint fke2b8465789fe23f0
            references public.menu_item,
    order_type_id integer not null
        constraint fke2b846573ac1d2e0
            references public.order_type
);

alter table public.item_order_type
    owner to appuser95;

create table public.menuitem_discount
(
    discount_id integer not null
        constraint fkd89ccdeed3e91e11
            references public.coupon_and_discount,
    menuitem_id integer not null
        constraint fkd89ccdee33662891
            references public.menu_item
);

alter table public.menuitem_discount
    owner to appuser95;

create table public.menuitem_modifiergroup
(
    id                        serial
        primary key,
    min_quantity              integer,
    max_quantity              integer,
    sort_order                integer,
    modifier_group            integer
        constraint fk312b355b7f2f368
            references public.menu_modifier_group,
    menuitem_modifiergroup_id integer
        constraint fk312b355b6e7b8b68
            references public.menu_item
);

alter table public.menuitem_modifiergroup
    owner to appuser95;

create table public.menuitem_pizzapirce
(
    menu_item_id   integer not null
        constraint fk17bd51a089fe23f0
            references public.menu_item,
    pizza_price_id integer not null
        constraint fk17bd51a0ae5d580
            references public.pizza_price
);

alter table public.menuitem_pizzapirce
    owner to appuser95;

create table public.menuitem_shift
(
    id          serial
        primary key,
    shift_price double precision,
    shift_id    integer
        constraint fke03c92d57660a5e3
            references public.shift,
    menuitem_id integer
        constraint fke03c92d533662891
            references public.menu_item
);

alter table public.menuitem_shift
    owner to appuser95;

create table public.menu_item_properties
(
    menu_item_id   integer      not null
        constraint fkf94186ff89fe23f0
            references public.menu_item,
    property_value varchar(100),
    property_name  varchar(255) not null,
    primary key (menu_item_id, property_name)
);

alter table public.menu_item_properties
    owner to appuser95;

create table public.recepie
(
    id        serial
        primary key,
    menu_item integer
        constraint fk6b4e177764931efc
            references public.menu_item
);

alter table public.recepie
    owner to appuser95;

alter table public.menu_item
    add constraint fk4cd5a1f3f3b77c57
        foreign key (recepie) references public.recepie;

create table public.recepie_item
(
    id                   serial
        primary key,
    percentage           double precision,
    inventory_deductable boolean,
    inventory_item       integer
        constraint fk855626db1682b10e
            references public.inventory_item,
    recepie_id           integer
        constraint fk855626dbcae89b83
            references public.recepie
);

alter table public.recepie_item
    owner to appuser95;

create table public.terminal
(
    id              integer not null
        primary key,
    name            varchar(60),
    terminal_key    varchar(120),
    opening_balance double precision,
    current_balance double precision,
    has_cash_drawer boolean,
    in_use          boolean,
    active          boolean,
    location        varchar(320),
    floor_id        integer,
    assigned_user   integer
);

alter table public.terminal
    owner to appuser95;

create table public.cash_drawer
(
    id          serial
        primary key,
    terminal_id integer
        constraint fk6221077d2ad2d031
            references public.terminal
);

alter table public.cash_drawer
    owner to appuser95;

create table public.menu_item_terminal_ref
(
    menu_item_id integer not null
        constraint fk9ea1afc89fe23f0
            references public.menu_item,
    terminal_id  integer not null
        constraint fk9ea1afc2ad2d031
            references public.terminal
);

alter table public.menu_item_terminal_ref
    owner to appuser95;

create table public.terminal_properties
(
    id             integer      not null
        constraint fk963f26d69d31df8e
            references public.terminal,
    property_value varchar(255),
    property_name  varchar(255) not null,
    primary key (id, property_name)
);

alter table public.terminal_properties
    owner to appuser95;

create table public.user_permission
(
    name varchar(40) not null
        primary key
);

alter table public.user_permission
    owner to appuser95;

create table public.user_type
(
    id     serial
        primary key,
    p_name varchar(60)
);

alter table public.user_type
    owner to appuser95;

create table public.users
(
    auto_id                serial
        primary key,
    user_id                integer
        unique,
    user_pass              varchar(16) not null
        unique,
    first_name             varchar(30),
    last_name              varchar(30),
    ssn                    varchar(30),
    cost_per_hour          double precision,
    clocked_in             boolean,
    last_clock_in_time     timestamp,
    last_clock_out_time    timestamp,
    phone_no               varchar(20),
    is_driver              boolean,
    available_for_delivery boolean,
    active                 boolean,
    shift_id               integer
        constraint fk4d495e87660a5e3
            references public.shift,
    currentterminal        integer
        constraint fk4d495e8d9409968
            references public.terminal,
    n_user_type            integer
        constraint fk4d495e8897b1e39
            references public.user_type
);

alter table public.users
    owner to appuser95;

create table public.action_history
(
    id          serial
        primary key,
    action_time timestamp,
    action_name varchar(255),
    description varchar(255),
    user_id     integer
        constraint fk3f3af36b3e20ad51
            references public.users
);

alter table public.action_history
    owner to appuser95;

create table public.attendence_history
(
    id             serial
        primary key,
    clock_in_time  timestamp,
    clock_out_time timestamp,
    clock_in_hour  smallint,
    clock_out_hour smallint,
    clocked_out    boolean,
    user_id        integer
        constraint fkdfe829a3e20ad51
            references public.users,
    shift_id       integer
        constraint fkdfe829a7660a5e3
            references public.shift,
    terminal_id    integer
        constraint fkdfe829a2ad2d031
            references public.terminal
);

alter table public.attendence_history
    owner to appuser95;

create table public.cash_drawer_reset_history
(
    id         serial
        primary key,
    reset_time timestamp,
    user_id    integer
        constraint fk719418223e20ad51
            references public.users
);

alter table public.cash_drawer_reset_history
    owner to appuser95;

create table public.drawer_assigned_history
(
    id        serial
        primary key,
    time      timestamp,
    operation varchar(60),
    a_user    integer
        constraint fk5a823c91f1dd782b
            references public.users
);

alter table public.drawer_assigned_history
    owner to appuser95;

create table public.drawer_pull_report
(
    id                         serial
        primary key,
    report_time                timestamp,
    reg                        varchar(15),
    ticket_count               integer,
    begin_cash                 double precision,
    net_sales                  double precision,
    sales_tax                  double precision,
    cash_tax                   double precision,
    total_revenue              double precision,
    gross_receipts             double precision,
    giftcertreturncount        integer,
    giftcertreturnamount       double precision,
    giftcertchangeamount       double precision,
    cash_receipt_no            integer,
    cash_receipt_amount        double precision,
    credit_card_receipt_no     integer,
    credit_card_receipt_amount double precision,
    debit_card_receipt_no      integer,
    debit_card_receipt_amount  double precision,
    refund_receipt_count       integer,
    refund_amount              double precision,
    receipt_differential       double precision,
    cash_back                  double precision,
    cash_tips                  double precision,
    charged_tips               double precision,
    tips_paid                  double precision,
    tips_differential          double precision,
    pay_out_no                 integer,
    pay_out_amount             double precision,
    drawer_bleed_no            integer,
    drawer_bleed_amount        double precision,
    drawer_accountable         double precision,
    cash_to_deposit            double precision,
    variance                   double precision,
    delivery_charge            double precision,
    totalvoidwst               double precision,
    totalvoid                  double precision,
    totaldiscountcount         integer,
    totaldiscountamount        double precision,
    totaldiscountsales         double precision,
    totaldiscountguest         integer,
    totaldiscountpartysize     integer,
    totaldiscountchecksize     integer,
    totaldiscountpercentage    double precision,
    totaldiscountratio         double precision,
    user_id                    integer
        constraint fkaec362203e20ad51
            references public.users,
    terminal_id                integer
        constraint fkaec362202ad2d031
            references public.terminal
);

alter table public.drawer_pull_report
    owner to appuser95;

create table public.currency_balance
(
    id             serial
        primary key,
    balance        double precision,
    currency_id    integer
        constraint fk2cc0e08e28dd6c11
            references public.currency,
    cash_drawer_id integer
        constraint fk2cc0e08e9006558
            references public.cash_drawer,
    dpr_id         integer
        constraint fk2cc0e08efb910735
            references public.drawer_pull_report
);

alter table public.currency_balance
    owner to appuser95;

create index drawer_report_time
    on public.drawer_pull_report (report_time);

create table public.drawer_pull_report_voidtickets
(
    dpreport_id integer not null
        constraint fk98cf9b143ef4cd9b
            references public.drawer_pull_report,
    code        integer,
    reason      varchar(255),
    hast        varchar(255),
    quantity    integer,
    amount      double precision
);

alter table public.drawer_pull_report_voidtickets
    owner to appuser95;

create table public.employee_in_out_history
(
    id          serial
        primary key,
    out_time    timestamp,
    in_time     timestamp,
    out_hour    smallint,
    in_hour     smallint,
    clock_out   boolean,
    user_id     integer
        constraint fk6d5db9fa3e20ad51
            references public.users,
    shift_id    integer
        constraint fk6d5db9fa7660a5e3
            references public.shift,
    terminal_id integer
        constraint fk6d5db9fa2ad2d031
            references public.terminal
);

alter table public.employee_in_out_history
    owner to appuser95;

create table public.gratuity
(
    id          serial
        primary key,
    amount      double precision,
    paid        boolean,
    refunded    boolean,
    ticket_id   integer,
    owner_id    integer
        constraint fk34e4e377aa075d69
            references public.users,
    terminal_id integer
        constraint fk34e4e3772ad2d031
            references public.terminal
);

alter table public.gratuity
    owner to appuser95;

create table public.guest_check_print
(
    id           serial
        primary key,
    ticket_id    integer,
    table_no     varchar(255),
    ticket_total double precision,
    print_time   timestamp,
    user_id      integer
        constraint fkce827c6f3e20ad51
            references public.users
);

alter table public.guest_check_print
    owner to appuser95;

create table public.table_booking_info
(
    id                serial
        primary key,
    from_date         timestamp,
    to_date           timestamp,
    guest_count       integer,
    status            varchar(30),
    payment_status    varchar(30),
    booking_confirm   varchar(30),
    booking_charge    double precision,
    remaining_balance double precision,
    paid_amount       double precision,
    booking_id        varchar(30),
    booking_type      varchar(30),
    user_id           integer
        constraint fk301c4de53e20ad51
            references public.users,
    customer_id       integer
        constraint fk301c4de59e1c3cf1
            references public.customer
);

alter table public.table_booking_info
    owner to appuser95;

create index fromdate
    on public.table_booking_info (from_date);

create index todate
    on public.table_booking_info (to_date);

create table public.table_booking_mapping
(
    booking_id integer not null
        constraint fk6bc51417160de3b1
            references public.table_booking_info,
    table_id   integer not null
        constraint fk6bc51417dc46948d
            references public.shop_table
);

alter table public.table_booking_mapping
    owner to appuser95;

alter table public.terminal
    add constraint fke83d827c969c6de
        foreign key (assigned_user) references public.users;

create table public.ticket
(
    id                  serial
        primary key,
    global_id           varchar(16)
        unique,
    create_date         timestamp,
    closing_date        timestamp,
    active_date         timestamp,
    deliveery_date      timestamp,
    creation_hour       integer,
    paid                boolean,
    voided              boolean,
    void_reason         varchar(255),
    wasted              boolean,
    refunded            boolean,
    settled             boolean,
    drawer_resetted     boolean,
    sub_total           double precision,
    total_discount      double precision,
    total_tax           double precision,
    total_price         double precision,
    paid_amount         double precision,
    due_amount          double precision,
    advance_amount      double precision,
    adjustment_amount   double precision,
    number_of_guests    integer,
    status              varchar(30),
    bar_tab             boolean,
    is_tax_exempt       boolean,
    is_re_opened        boolean,
    service_charge      double precision,
    delivery_charge     double precision,
    customer_id         integer,
    delivery_address    varchar(120),
    customer_pickeup    boolean,
    delivery_extra_info varchar(255),
    ticket_type         varchar(20),
    shift_id            integer
        constraint fk937b5f0c7660a5e3
            references public.shift,
    owner_id            integer
        constraint fk937b5f0caa075d69
            references public.users,
    driver_id           integer
        constraint fk937b5f0cf575c7d4
            references public.users,
    gratuity_id         integer
        constraint fk937b5f0cc188ea51
            references public.gratuity,
    void_by_user        integer
        constraint fk937b5f0c1f6a9a4a
            references public.users,
    terminal_id         integer
        constraint fk937b5f0c2ad2d031
            references public.terminal
);

alter table public.ticket
    owner to appuser95;

alter table public.gratuity
    add constraint fk34e4e3771df2d7f1
        foreign key (ticket_id) references public.ticket;

create index creationhour
    on public.ticket (creation_hour);

create index ticketpaid
    on public.ticket (paid);

create index ticketactivedate
    on public.ticket (active_date);

create index ticketcreatedate
    on public.ticket (create_date);

create index ticketsettled
    on public.ticket (settled);

create index deliverydate
    on public.ticket (deliveery_date);

create index ticketclosingdate
    on public.ticket (closing_date);

create index drawerresetted
    on public.ticket (drawer_resetted);

create index ticketvoided
    on public.ticket (voided);

create table public.ticket_discount
(
    id             serial
        primary key,
    discount_id    integer,
    name           varchar(30),
    type           integer,
    auto_apply     boolean,
    minimum_amount integer,
    value          double precision,
    ticket_id      integer
        constraint fk1fa465141df2d7f1
            references public.ticket
);

alter table public.ticket_discount
    owner to appuser95;

create table public.ticket_item
(
    id                            serial
        primary key,
    item_id                       integer,
    item_count                    integer,
    item_quantity                 double precision,
    item_name                     varchar(120),
    item_unit_name                varchar(20),
    group_name                    varchar(120),
    category_name                 varchar(120),
    item_price                    double precision,
    item_tax_rate                 double precision,
    sub_total                     double precision,
    sub_total_without_modifiers   double precision,
    discount                      double precision,
    tax_amount                    double precision,
    tax_amount_without_modifiers  double precision,
    total_price                   double precision,
    total_price_without_modifiers double precision,
    beverage                      boolean,
    inventory_handled             boolean,
    print_to_kitchen              boolean,
    treat_as_seat                 boolean,
    seat_number                   integer,
    fractional_unit               boolean,
    has_modiiers                  boolean,
    printed_to_kitchen            boolean,
    status                        varchar(255),
    stock_amount_adjusted         boolean,
    pizza_type                    boolean,
    size_modifier_id              integer,
    ticket_id                     integer
        constraint fk979f54661df2d7f1
            references public.ticket,
    pg_id                         integer
        constraint fk979f54665cf1375f
            references public.printer_group,
    pizza_section_mode            integer
);

alter table public.ticket_item
    owner to appuser95;

create table public.ticket_item_cooking_instruction
(
    ticket_item_id   integer not null
        constraint fk3825f9d0dec6120a
            references public.ticket_item,
    description      varchar(60),
    printedtokitchen boolean,
    item_order       integer not null,
    primary key (ticket_item_id, item_order)
);

alter table public.ticket_item_cooking_instruction
    owner to appuser95;

create table public.ticket_item_discount
(
    id               serial
        primary key,
    discount_id      integer,
    name             varchar(30),
    type             integer,
    auto_apply       boolean,
    minimum_quantity integer,
    value            double precision,
    amount           double precision,
    ticket_itemid    integer
        constraint fk3df5d4fab9276e77
            references public.ticket_item
);

alter table public.ticket_item_discount
    owner to appuser95;

create table public.ticket_item_modifier
(
    id                   serial
        primary key,
    item_id              integer,
    group_id             integer,
    item_count           integer,
    modifier_name        varchar(120),
    modifier_price       double precision,
    modifier_tax_rate    double precision,
    modifier_type        integer,
    subtotal_price       double precision,
    total_price          double precision,
    tax_amount           double precision,
    info_only            boolean,
    section_name         varchar(20),
    multiplier_name      varchar(20),
    print_to_kitchen     boolean,
    section_wise_pricing boolean,
    status               varchar(10),
    printed_to_kitchen   boolean,
    ticket_item_id       integer
        constraint fk8fd6290dec6120a
            references public.ticket_item
);

alter table public.ticket_item_modifier
    owner to appuser95;

alter table public.ticket_item
    add constraint fk979f546633e5d3b2
        foreign key (size_modifier_id) references public.ticket_item_modifier;

create table public.ticket_item_addon_relation
(
    ticket_item_id integer not null
        constraint fk9f199634dec6120a
            references public.ticket_item,
    modifier_id    integer not null
        constraint fk9f1996346c108ef0
            references public.ticket_item_modifier,
    list_order     integer not null,
    primary key (ticket_item_id, list_order)
);

alter table public.ticket_item_addon_relation
    owner to appuser95;

create table public.ticket_item_modifier_relation
(
    ticket_item_id integer not null
        constraint fk5d3f9acbdec6120a
            references public.ticket_item,
    modifier_id    integer not null
        constraint fk5d3f9acb6c108ef0
            references public.ticket_item_modifier,
    list_order     integer not null,
    primary key (ticket_item_id, list_order)
);

alter table public.ticket_item_modifier_relation
    owner to appuser95;

create table public.ticket_properties
(
    id             integer      not null
        constraint fk70ecd046223049de
            references public.ticket,
    property_value varchar(1000),
    property_name  varchar(255) not null,
    primary key (id, property_name)
);

alter table public.ticket_properties
    owner to appuser95;

create table public.ticket_table_num
(
    ticket_id integer not null
        constraint fk65af15e21df2d7f1
            references public.ticket,
    table_id  integer
);

alter table public.ticket_table_num
    owner to appuser95;

create table public.transactions
(
    id                         serial
        primary key,
    payment_type               varchar(30) not null,
    global_id                  varchar(16)
        unique,
    transaction_time           timestamp,
    amount                     double precision,
    tips_amount                double precision,
    tips_exceed_amount         double precision,
    tender_amount              double precision,
    transaction_type           varchar(30) not null,
    custom_payment_name        varchar(60),
    custom_payment_ref         varchar(120),
    custom_payment_field_name  varchar(60),
    payment_sub_type           varchar(40) not null,
    captured                   boolean,
    voided                     boolean,
    authorizable               boolean,
    card_holder_name           varchar(60),
    card_number                varchar(40),
    card_auth_code             varchar(30),
    card_type                  varchar(20),
    card_transaction_id        varchar(255),
    card_merchant_gateway      varchar(60),
    card_reader                varchar(30),
    card_aid                   varchar(120),
    card_arqc                  varchar(120),
    card_ext_data              varchar(255),
    gift_cert_number           varchar(64),
    gift_cert_face_value       double precision,
    gift_cert_paid_amount      double precision,
    gift_cert_cash_back_amount double precision,
    drawer_resetted            boolean,
    note                       varchar(255),
    terminal_id                integer
        constraint fkfe9871552ad2d031
            references public.terminal,
    ticket_id                  integer
        constraint fkfe9871551df2d7f1
            references public.ticket,
    user_id                    integer
        constraint fkfe9871553e20ad51
            references public.users,
    payout_reason_id           integer
        constraint fkfe987155fc697d9e
            references public.payout_reasons,
    payout_recepient_id        integer
        constraint fkfe987155ca43b6
            references public.payout_recepients
);

alter table public.transactions
    owner to appuser95;

create index tran_drawer_resetted
    on public.transactions (drawer_resetted);

create table public.transaction_properties
(
    id             integer      not null
        constraint fke3de65548e8203bc
            references public.transactions,
    property_value varchar(255),
    property_name  varchar(255) not null,
    primary key (id, property_name)
);

alter table public.transaction_properties
    owner to appuser95;

create table public.user_user_permission
(
    permissionid integer     not null
        constraint fk2dbeaa4f283ecc6
            references public.user_type,
    elt          varchar(40) not null
        constraint fk2dbeaa4f8f23f5e
            references public.user_permission,
    primary key (permissionid, elt)
);

alter table public.user_user_permission
    owner to appuser95;

create table public.virtual_printer
(
    id       serial
        primary key,
    name     varchar(60) not null
        unique,
    type     integer,
    priority integer,
    enabled  boolean
);

alter table public.virtual_printer
    owner to appuser95;

create table public.terminal_printers
(
    id                 serial
        primary key,
    terminal_id        integer
        constraint fk99ede5fc2ad2d031
            references public.terminal,
    printer_name       varchar(60),
    virtual_printer_id integer
        constraint fk99ede5fcc433e65a
            references public.virtual_printer
);

alter table public.terminal_printers
    owner to appuser95;

create table public.virtualprinter_order_type
(
    printer_id integer not null
        constraint fk9af7853bcf15f4a6
            references public.virtual_printer,
    order_type varchar(255)
);

alter table public.virtualprinter_order_type
    owner to appuser95;

create table public.void_reasons
(
    id          serial
        primary key,
    reason_text varchar(255)
);

alter table public.void_reasons
    owner to appuser95;

create table public.zip_code_vs_delivery_charge
(
    auto_id         serial
        primary key,
    zip_code        varchar(10)      not null,
    delivery_charge double precision not null
);

alter table public.zip_code_vs_delivery_charge
    owner to appuser95;

