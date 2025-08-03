erDiagram
    ActionHistory {
        Integer id PK
        Timestamp actionTime
        String actionName
        String description
    }
    AttendenceHistory {
        Integer id PK
        Timestamp clockInTime
        Timestamp clockOutTime
        Short clockInHour
        Short clockOutHour
        Boolean clockedOut
    }
    BusinessIntelligence {
        Integer id PK
        String reportName
        String reportType
        String description
        Date createdDate
        Date updatedDate
        String createdBy
        String status
        String dataSource
        String querySql
        String parameters
        String outputFormat
        String scheduleCron
        Boolean isActive
    }
    CashDrawer {
        Integer id PK
    }
    CashDrawerResetHistory {
        Integer id PK
        Timestamp resetTime
    }
    CookingInstruction {
        Integer id PK
        String description
    }
    CouponAndDiscount {
        Integer id PK
        String name
        Integer type
        String barcode
        Integer qualificationType
        Boolean applyToAll
        Integer minimumBuy
        Integer maximumOff
        Double value
        Timestamp expiryDate
        Boolean enabled
        Boolean autoApply
        Boolean modifiable
        Boolean neverExpire
        String uuid
    }
    Currency {
        Integer id PK
        String code
        String name
        String symbol
        Double exchangeRate
        Integer decimalPlaces
        Double tolerance
        Double buyPrice
        Double salesPrice
        Boolean main
    }
    CurrencyBalance {
        Integer id PK
        Double balance
    }
    Customer {
        Integer autoId PK
        String loyaltyNo
        Integer loyaltyPoint
        String socialSecurityNumber
        byte[] picture
        String homephoneNo
        String mobileNo
        String workphoneNo
        String email
        String salutation
        String firstName
        String lastName
        String name
        String dob
        String ssn
        String address
        String city
        String state
        String zipCode
        String country
        Boolean vip
        Double creditLimit
        Double creditSpent
        String creditCardNo
        String note
    }
    CustomPayment {
        Integer id PK
        String name
        Boolean requiredRefNumber
        String refNumberFieldName
    }
    DataUpdateInfo {
        Integer id PK
        Timestamp lastUpdateTime
    }
    DeliveryAddress {
        Integer id PK
        String address
        String phoneExtension
        String roomNo
        Double distance
    }
    DeliveryCharge {
        Integer id PK
        String name
        String zipCode
        Double startRange
        Double endRange
        Double chargeAmount
    }
    DeliveryConfiguration {
        Integer id PK
        String unitName
        String unitSymbol
        Boolean chargeByZipCode
    }
    DeliveryInstruction {
        Integer id PK
        String notes
    }
    DrawerAssignedHistory {
        Integer id PK
        Timestamp time
        String operation
    }
    DrawerPullReport {
        Integer id PK
        Timestamp reportTime
        String reg
        Integer ticketCount
        Double beginCash
        Double netSales
        Double salesTax
        Double cashTax
        Double totalRevenue
        Double grossReceipts
        Integer giftCertReturnCount
        Double giftCertReturnAmount
        Double giftCertChangeAmount
        Integer cashReceiptNo
        Double cashReceiptAmount
        Integer creditCardReceiptNo
        Double creditCardReceiptAmount
        Integer debitCardReceiptNo
        Double debitCardReceiptAmount
        Integer refundReceiptCount
        Double refundAmount
        Double receiptDifferential
        Double cashBack
        Double cashTips
        Double chargedTips
        Double tipsPaid
        Double tipsDifferential
        Integer payOutNo
        Double payOutAmount
        Integer drawerBleedNo
        Double drawerBleedAmount
        Double drawerAccountable
        Double cashToDeposit
        Double variance
        Double deliveryCharge
        Double totalVoidWithSalesTax
        Double totalVoid
        Integer totalDiscountCount
        Double totalDiscountAmount
        Double totalDiscountSales
        Integer totalDiscountGuest
        Integer totalDiscountPartySize
        Integer totalDiscountCheckSize
        Double totalDiscountPercentage
        Double totalDiscountRatio
    }
    DrawerPullReportVoidTicket {
        Integer code PK
        String reason
        String hast
        Integer quantity
        Double amount
    }
    EmployeeInOutHistory {
        Integer id PK
        Timestamp outTime
        Timestamp inTime
        Short outHour
        Short inHour
        Boolean clockOut
    }
    GlobalConfig {
        Integer id PK
        String posKey
        String posValue
    }
    Gratuity {
        Integer id PK
        Double amount
        Boolean paid
        Boolean refunded
        Integer ticket_id
    }
    GuestCheckPrint {
        Integer id PK
        Integer ticket_id
        String tableNo
        Double ticketTotal
        Timestamp printTime
    }
    InventoryGroup {
        Integer id PK
        String name
        Boolean visible
    }
    InventoryItem {
        Integer id PK
        Timestamp createTime
        Timestamp lastUpdateDate
        String name
        String packageBarcode
        String unitBarcode
        Double unitPerPackage
        Integer sortOrder
        Integer packageReorderLevel
        Integer packageReplenishLevel
        String description
        Double averagePackagePrice
        Double totalUnitPackages
        Double totalRecepieUnits
        Double unitPurchasePrice
        Double unitSellingPrice
        Boolean visible
    }
    InventoryLocation {
        Integer id PK
        String name
        Integer sortOrder
        Boolean visible
    }
    InventoryMetaCode {
        Integer id PK
        String type
        String codeText
        Integer codeNo
        String description
    }
    InventoryTransaction {
        Integer id PK
        Timestamp transactionDate
        Double unitQuantity
        Double unitPrice
        String remark
        Integer tran_type
    }
    InventoryUnit {
        Integer id PK
        String shortName
        String longName
        String altName
        String convFactor1
        String convFactor2
        String convFactor3
    }
    InventoryVendor {
        Integer id PK
        String name
        Boolean visible
        String address
        String city
        String state
        String zip
        String country
        String email
        String phone
        String fax
    }
    InventoryWarehouse {
        Integer id PK
        String name
        Boolean visible
    }
    KitchenTicket {
        Integer id PK
        Integer ticketId
        Timestamp createDate
        Timestamp closeDate
        Boolean voided
        Integer sequenceNumber
        String status
        String serverName
        String ticketType
    }
    KitchenTicketItem {
        Integer id PK
        Boolean cookable
        Integer ticket_item_id
        Integer ticket_item_modifier_id
        String menuItemCode
        String menuItemName
        Integer menu_item_group_id
        String menu_item_group_name
        Integer quantity
        Double fractionalQuantity
        Boolean fractionalUnit
        String unitName
        Integer sortOrder
        Boolean voided
        String status
        Integer item_order
    }
    KitTicketTableNum {
        Integer table_id PK
    }
    MenuCategory {
        Integer id PK
        String name
        String translatedName
        Boolean visible
        Boolean beverage
        Integer sortOrder
        Integer buttonColor
        Integer textColor
    }
    MenuGroup {
        Integer id PK
        String name
        String translatedName
        Boolean visible
        Integer sortOrder
        Integer buttonColor
        Integer textColor
    }
    MenuItem {
        Integer id PK
        String name
        String description
        String unitName
        String translatedName
        String barcode
        Double buyPrice
        Double stockAmount
        Double price
        Double discountRate
        Boolean visible
        Boolean disableWhenStockAmountIsZero
        Integer sortOrder
        Integer buttonColor
        Integer textColor
        byte[] image
        Boolean showImageOnly
        Boolean fractionalUnit
        Boolean pizzaType
        Integer defaultSellPortion
        Integer recepieId
    }
    MenuItemModifierGroup {
        Integer id PK
        Integer minQuantity
        Integer maxQuantity
        Integer sortOrder
    }
    MenuItemShift {
        Integer id PK
        Double shiftPrice
    }
    MenuItemSize {
        Integer id PK
        String name
        String translatedName
        String description
        Integer sortOrder
        Double sizeInInch
        Boolean defaultSize
    }
    ModifierBehavior {
        Integer id PK
        String name
        String displayText
        String priceAdjustmentType
        Double defaultPriceAdjustment
        Boolean kitchenInstructionFlag
        Boolean isMutuallyExclusive
        Integer displayOrder
        Boolean isActive
    }

    MenuModifier {
        Integer id PK
        String name
        String translatedName
        Double price
        Double extraPrice
        Integer sortOrder
        Integer buttonColor
        Integer textColor
        Boolean enabled
        Boolean fixedPrice
        Boolean printToKitchen
        Boolean sectionWisePricing
        Boolean pizzaModifier
        Integer modifierBehaviorId FK
    }

    MenuModifier ||--o{ ModifierBehavior : "has"
    MenuModifierGroup {
        Integer id PK
        String name
        String translatedName
        Boolean enabled
        Boolean exclusived
        Boolean required
    }
    MenuModifierPizzaModifierPrice {
    }
    ModifierMultiplierPrice {
        Integer id PK
        Double price
    }
    Multiplier {
        String name PK
        String ticketPrefix
        Double rate
        Integer sortOrder
        Boolean defaultMultiplier
        Boolean main
        Integer buttonColor
        Integer textColor
    }
    OnlineOrder {
        String id PK
        Long versionNo
        Timestamp lastUpdateTime
        Timestamp lastSyncTime
        Timestamp orderDate
        String custId
        String storeId
        String storeSchema
        String storeName
        String outletId
        String ticketId
        String orderType
        String orderStatus
        Boolean paid
        Boolean settled
        Timestamp expiryDate
        String source
        String ticketJson
        String properties
    }
    OrderType {
        Integer id PK
        String name
        Boolean enabled
        Boolean showTableSelection
        Boolean showGuestSelection
        Boolean shouldPrintToKitchen
        Boolean prepaid
        Boolean closeOnPaid
        Boolean requiredCustomerData
        Boolean delivery
        Boolean showItemBarcode
        Boolean showInLoginScreen
        Boolean consolidateItemsInReceipt
        Boolean allowSeatBasedOrder
        Boolean hideItemWithEmptyInventory
        Boolean hasForhereAndTogo
        Boolean preAuthCreditCard
        Boolean barTab
        Boolean retailOrder
        Boolean showPriceOnButton
        Boolean showStockCountOnButton
        Boolean showUnitPriceInTicketGrid
        String properties
    }
    PackagingUnit {
        Integer id PK
        String name
        String shortName
        Double factor
        Boolean baseUnit
        String dimension
    }
    PayoutReason {
        Integer id PK
        String reason
    }
    PayoutRecipient {
        Integer id PK
        String name
    }
    PizzaCrust {
        Integer id PK
        String name
        String translatedName
        String description
        Integer sortOrder
        Boolean defaultCrust
    }
    PizzaModifierPrice {
        Integer id PK
    }
    PizzaPrice {
        Integer id PK
        Double price
    }
    PrinterConfiguration {
        Integer id PK
        String receiptPrinter
        String kitchenPrinter
        Boolean prwts
        Boolean prwtp
        Boolean pkwts
        Boolean pkwtp
        Boolean unpft
        Boolean unpfk
    }
    PrinterGroup {
        Integer id PK
        String name
        Boolean isDefault
    }
    PrinterGroupPrinters {
        String printer_name PK
    }
    PurchaseOrder {
        Integer id PK
        String orderId
        String name
    }
    Recepie {
        Integer id PK
    }
    RecepieItem {
        Integer id PK
        Double percentage
        Boolean inventoryDeductable
    }
    Restaurant {
        Integer id PK
        Integer uniqueId
        String uuid
        String name
        String addressLine1
        String addressLine2
        String addressLine3
        String zipCode
        String telephone
        Integer capacity
        Integer tables
        String cname
        String csymbol
        Double sc_percentage
        Double gratuity_percentage
        String ticketFooter
        Boolean priceIncludesTax
        Boolean allowModifierMaxExceed
    }
    Shift {
        Integer id PK
        String name
        Timestamp startTime
        Timestamp endTime
        Long shiftLength
    }
    ShopFloor {
        Integer id PK
        String name
        Boolean occupied
        byte[] image
    }
    ShopFloorTemplate {
        Integer id PK
        String name
        Boolean defaultFloor
        Boolean main
    }
    ShopTable {
        Integer id PK
        String name
        String description
        Integer capacity
        Integer x
        Integer y
    }
    ShopTableStatus {
        Integer id PK
        Integer tableStatus
    }
    ShopTableType {
        Integer id PK
        String description
        String name
    }
    TableBookingInfo {
        Integer id PK
        Timestamp fromDate
        Timestamp toDate
        Integer guestCount
        String status
        String paymentStatus
        String bookingConfirm
        Double bookingCharge
        Double remainingBalance
        Double paidAmount
        String bookingId
        String bookingType
    }
    TableBookingMapping {
    }
    TableTicketNum {
        Integer ticket_id PK
        Integer userId
        String userName
    }
    TableTypeRelation {
    }
    Tax {
        Integer id PK
        String name
        Double rate
    }
    TaxGroup {
        String id PK
        String name
    }
    Terminal {
        Integer id PK
        String name
        String terminalKey
        Double openingBalance
        Double currentBalance
        Boolean hasCashDrawer
        Boolean inUse
        Boolean active
        String location
        Integer floorId
        Integer assignedUser
    }
    TerminalPrinter {
        Integer id PK
        String printerName
    }
    Ticket {
        Integer id PK
        String globalId
        Timestamp createDate
        Timestamp closingDate
        Timestamp activeDate
        Timestamp deliveery_date
        Integer creationHour
        Boolean paid
        Boolean voided
        String voidReason
        Boolean wasted
        Boolean refunded
        Boolean settled
        Boolean drawerResetted
        Double subTotal
        Double totalDiscount
        Double totalTax
        Double totalPrice
        Double paidAmount
        Double dueAmount
        Double advanceAmount
        Double adjustmentAmount
        Integer numberOfGuests
        String status
        Boolean barTab
        Boolean isTaxExempt
        Boolean isReOpened
        Double serviceCharge
        Double deliveryCharge
        Integer customerId
        String deliveryAddress
        Boolean customerPickup
        String deliveryExtraInfo
        String ticketType
    }
    TicketDiscount {
        Integer id PK
        Integer discount_id
        String name
        Integer type
        Boolean autoApply
        Integer minimumAmount
        Double value
    }
    TicketItem {
        Integer id PK
        Integer item_id
        Integer itemCount
        Double itemQuantity
        String itemName
        String itemUnitName
        String groupName
        String categoryName
        Double itemPrice
        Double itemTaxRate
        Double subTotal
        Double subTotalWithoutModifiers
        Double discount
        Double taxAmount
        Double taxAmountWithoutModifiers
        Double totalPrice
        Double totalPriceWithoutModifiers
        Boolean beverage
        Boolean inventoryHandled
        Boolean printToKitchen
        Boolean treatAsSeat
        Integer seatNumber
        Boolean fractionalUnit
        Boolean hasModiiers
        Boolean printedToKitchen
        String status
        Boolean stockAmountAdjusted
        Boolean pizzaType
        Integer sizeModifierId
        Integer pizzaSectionMode
    }
    TicketItemAddonRelation {
        Integer list_order PK
    }
    TicketItemCookingInstruction {
        Integer item_order PK
        String description
        Boolean printedtokitchen
    }
    TicketItemDiscount {
        Integer id PK
        Integer discount_id
        String name
        Integer type
        Boolean autoApply
        Integer minimumQuantity
        Double value
        Double amount
    }
    TicketItemModifier {
        Integer id PK
        Integer item_id
        Integer group_id
        Integer itemCount
        String modifierName
        Double modifierPrice
        Double modifierTaxRate
        Integer modifierType
        Double subtotalPrice
        Double totalPrice
        Double taxAmount
        Boolean infoOnly
        String sectionName
        String multiplierName
        Boolean printToKitchen
        Boolean sectionWisePricing
        String status
        Boolean printedToKitchen
    }
    TicketItemModifierRelation {
        Integer list_order PK
    }
    TicketTableNum {
        Integer table_id PK
    }
    Transaction {
        Integer id PK
        String paymentType
        String globalId
        Timestamp transactionTime
        Double amount
        Double tipsAmount
        Double tipsExceedAmount
        Double tenderAmount
        String transactionType
        String customPaymentName
        String customPaymentRef
        String customPaymentFieldName
        String paymentSubType
        Boolean captured
        Boolean voided
        Boolean authorizable
        String cardHolderName
        String cardNumber
        String cardAuthCode
        String cardType
        String cardTransactionId
        String cardMerchantGateway
        String cardReader
        String cardAid
        String cardArqc
        String cardExtData
        String giftCertNumber
        Double giftCertFaceValue
        Double giftCertPaidAmount
        Double giftCertCashBackAmount
        Boolean drawerResetted
        String note
    }
    User {
        Integer autoId PK
        Integer user_id
        String userPass
        String firstName
        String lastName
        String ssn
        Double costPerHour
        Boolean clockedIn
        Timestamp lastClockInTime
        Timestamp lastClockOutTime
        String phoneNo
        Boolean isDriver
        Boolean availableForDelivery
        Boolean active
    }
    UserPermission {
        String name PK
    }
    UserType {
        Integer id PK
        String p_name
    }
    UserUserPermission {
    }
    VirtualPrinter {
        Integer id PK
        String name
        Integer type
        Integer priority
        Boolean enabled
    }
    VirtualPrinterOrderType {
        String order_type PK
    }
    VoidReason {
        Integer id PK
        String reasonText
    }
    ZipCodeVsDeliveryCharge {
        Integer autoId PK
        String zipCode
        Double deliveryCharge
    }

    User ||--o{ ActionHistory : ""
    User ||--o{ AttendenceHistory : ""
    Shift ||--o{ AttendenceHistory : ""
    Terminal ||--o{ AttendenceHistory : ""
    Terminal ||--o{ CashDrawer : ""
    User ||--o{ CashDrawerResetHistory : ""
    Currency ||--o{ CurrencyBalance : ""
    CashDrawer ||--o{ CurrencyBalance : ""
    DrawerPullReport ||--o{ CurrencyBalance : ""
    Customer ||--o{ DeliveryAddress : ""
    Customer ||--o{ DeliveryInstruction : ""
    User ||--o{ DrawerAssignedHistory : ""
    User ||--o{ DrawerPullReport : ""
    Terminal ||--o{ DrawerPullReport : ""
    DrawerPullReport ||--o{ DrawerPullReportVoidTicket : ""
    User ||--o{ EmployeeInOutHistory : ""
    Shift ||--o{ EmployeeInOutHistory : ""
    Terminal ||--o{ EmployeeInOutHistory : ""
    User ||--o{ Gratuity : ""
    Terminal ||--o{ Gratuity : ""
    User ||--o{ GuestCheckPrint : ""
    InventoryGroup ||--o{ InventoryItem : ""
    InventoryLocation ||--o{ InventoryItem : ""
    InventoryVendor ||--o{ InventoryItem : ""
    PackagingUnit ||--o{ InventoryItem : ""
    InventoryWarehouse ||--o{ InventoryLocation : ""
    PurchaseOrder ||--o{ InventoryTransaction : ""
    InventoryItem ||--o{ InventoryTransaction : ""
    InventoryVendor ||--o{ InventoryTransaction : ""
    InventoryWarehouse }o--o{ InventoryTransaction : ""
    PrinterGroup ||--o{ KitchenTicket : ""
    KitchenTicket ||--o{ KitchenTicketItem : ""
    KitchenTicket ||--o{ KitTicketTableNum : ""
    MenuCategory ||--o{ MenuGroup : ""
    MenuGroup ||--o{ MenuItem : ""
    TaxGroup ||--o{ MenuItem : ""
    PrinterGroup ||--o{ MenuItem : ""
    MenuModifierGroup ||--o{ MenuItemModifierGroup : ""
    MenuItem ||--o{ MenuItemModifierGroup : ""
    Shift ||--o{ MenuItemShift : ""
    MenuItem ||--o{ MenuItemShift : ""
    MenuModifierGroup ||--o{ MenuModifier : ""
    Tax ||--o{ MenuModifier : ""
    MenuModifier }o--o{ MenuModifierPizzaModifierPrice : ""
    PizzaModifierPrice }o--o{ MenuModifierPizzaModifierPrice : ""
    Multiplier ||--o{ ModifierMultiplierPrice : ""
    MenuModifier ||--o{ ModifierMultiplierPrice : ""
    PizzaModifierPrice ||--o{ ModifierMultiplierPrice : ""
    MenuItemSize ||--o{ PizzaModifierPrice : ""
    MenuItemSize ||--o{ PizzaPrice : ""
    PizzaCrust ||--o{ PizzaPrice : ""
    OrderType ||--o{ PizzaPrice : ""
    PrinterGroup ||--o{ PrinterGroupPrinters : ""
    MenuItem ||--|| Recepie : ""
    InventoryItem ||--o{ RecepieItem : ""
    Recepie ||--o{ RecepieItem : ""
    ShopFloor ||--o{ ShopFloorTemplate : ""
    ShopFloor ||--o{ ShopTable : ""
    User ||--o{ TableBookingInfo : ""
    Customer ||--o{ TableBookingInfo : ""
    TableBookingInfo }o--o{ TableBookingMapping : ""
    ShopTable }o--o{ TableBookingMapping : ""
    ShopTableStatus ||--o{ TableTicketNum : ""
    ShopTable }o--o{ TableTypeRelation : ""
    ShopTableType }o--o{ TableTypeRelation : ""
    Terminal ||--o{ TerminalPrinter : ""
    VirtualPrinter ||--o{ TerminalPrinter : ""
    Shift ||--o{ Ticket : ""
    User ||--o{ Ticket : ""
    Gratuity ||--|| Ticket : ""
    Terminal ||--o{ Ticket : ""
    Ticket ||--o{ TicketDiscount : ""
    Ticket ||--o{ TicketItem : ""
    PrinterGroup ||--o{ TicketItem : ""
    TicketItem ||--o{ TicketItemAddonRelation : ""
    TicketItemModifier ||--o{ TicketItemAddonRelation : ""
    TicketItem ||--o{ TicketItemCookingInstruction : ""
    TicketItem ||--o{ TicketItemDiscount : ""
    TicketItem ||--o{ TicketItemModifier : ""
    TicketItem }o--o{ TicketItemModifierRelation : ""
    TicketItemModifier }o--o{ TicketItemModifierRelation : ""
    Ticket ||--o{ TicketTableNum : ""
    Terminal ||--o{ Transaction : ""
    Ticket ||--o{ Transaction : ""
    User ||--o{ Transaction : ""
    PayoutReason ||--o{ Transaction : ""
    PayoutRecipient ||--o{ Transaction : ""
    Shift ||--o{ User : ""
    Terminal ||--o{ User : ""
    UserType ||--o{ User : ""
    UserType }o--o{ UserUserPermission : ""
    UserPermission }o--o{ UserUserPermission : ""
    VirtualPrinter ||--o{ VirtualPrinterOrderType : ""
    MenuItem }o--o{ OrderType : ""
    MenuItem }o--o{ CouponAndDiscount : ""
    MenuItem }o--o{ PizzaPrice : ""
    MenuItem }o--o{ Terminal : ""
    TaxGroup }o--o{ Tax : ""