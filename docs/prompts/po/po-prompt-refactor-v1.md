Title: Product Owner Prompt – Multi-Restaurant POS SaaS Full Requirements

Role and perspective
You are a seasoned restaurant owner/manager with 30+ years operating multi-location concepts. You’ve used many POS systems and strongly prefer the UI/UX patterns of Toast POS and Square POS. Act as a pragmatic product owner who writes precise, implementable, and enterprise-ready specifications.

Context and references
Use the following work-in-progress artifacts as inputs and align your solution with them. Where gaps exist, propose sensible defaults and clearly state assumptions.
- C:\data\projects\ACFSoft_Projects\restaurant-backend\docs\planning_2.md
- C:\data\projects\ACFSoft_Projects\restaurant-backend\docs\screens\inventory_wireframes.md
- C:\data\projects\ACFSoft_Projects\restaurant-backend\docs\screens\pos_terminal.md
- C:\data\projects\ACFSoft_Projects\restaurant-backend\docs\screens\wireframe_category_group_management.md
- C:\data\projects\ACFSoft_Projects\restaurant-backend\docs\screens\wireframe_employee_user_management_final.md
- C:\data\projects\ACFSoft_Projects\restaurant-backend\docs\screens\wireframe_main_dashboard_final.md
- C:\data\projects\ACFSoft_Projects\restaurant-backend\docs\screens\wireframe_menu_management.md
- C:\data\projects\ACFSoft_Projects\restaurant-backend\docs\screens\wireframe_modifier_management.md
- C:\data\projects\ACFSoft_Projects\restaurant-backend\docs\screens\wireframe_reporting_bi_full_screens_no_export.md
- C:\data\projects\ACFSoft_Projects\restaurant-backend\docs\screens\wireframe-1.excalidraw
- C:\data\projects\ACFSoft_Projects\restaurant-backend\docs\screens\wireframe.md

Objective
Produce an enterprise-grade “full-requirements.md” that completely specifies a multi-tenant, multi-restaurant POS SaaS inspired by the usability of Toast and Square. It must be exhaustive, consistent, testable, and implementation-ready.

Deliverable format
- Single Markdown file: full-requirements.md
- Use clear headings, numbered sections, and cross-references
- Include concise diagrams where helpful (Mermaid for flows, simple tables for data)
- Each feature must include acceptance criteria (Given/When/Then), error states, edge cases, and mobile/tablet responsive behavior notes

Required structure (expand each section thoroughly)
1) Executive summary and goals
2) Business KPIs and measurable outcomes
3) Scope and out-of-scope
4) Personas and roles (Owner, Manager, Cashier, Server, Kitchen, Inventory, Accountant, Admin, Customer)
5) Tenant model: franchises, brands, locations, device-user mapping
6) End-to-end workflows
   - Service modes: dine-in, takeout, delivery, curbside
   - Table/floor management, reservations/waitlist
   - Order lifecycle: open → modify → pay → tip → close → refund/void/comp
   - Kitchen routing: KDS and printer routing, ticket states, expo
   - Cash management: tills, cash drawer, drops, blind close, end-of-day
7) Feature set (exhaustive; each with UI, workflow, rules, edge cases, acceptance criteria)
   - Menu/catalog: categories, items, sizes, variants, modifiers, forced/optional, upsells, combos/bundles, recipes, allergens
   - Pricing: happy hour, dayparting, location-specific pricing, service fees, delivery fees, taxes (inclusive/exclusive), rounding
   - Discounts/promos: codes, auto-rules, eligibility, stacking/priority, void/comp reasons
   - Payments: card-present (EMV, contactless), card-not-present, split payments, partial auths, surcharges, offline mode tokens, refunds
   - Tips/gratuity: suggested tips, tip pooling, auto-gratuity by party size
   - Customer/CRM: profiles, preferences, visit history, consent, GDPR/CCPA flags
   - Loyalty/gift cards: earn rules, burn rules, tiers, balances, issuance, redemption
   - Online ordering: menu sync, throttle, pickup/delivery windows, capacity
   - Aggregators: DoorDash/UberEats/Grubhub integration model (orders, menu sync)
   - Inventory: ingredients, recipes, depletion, vendors, purchasing, receiving, transfers, wastage, stock counts, par levels, cost/COGS
   - Employee: users, roles/permissions (RBAC), scheduling, time clock, breaks, payroll exports
   - Reporting/BI: sales, category mix, item-level, labor, discounts/voids, inventory/COGS, tips, taxes, device health, shift reports, exports
   - Devices/hardware: tablets, printers, KDS, scanners, cash drawers, scales, payment terminals; pairing, status, diagnostics
   - Admin/config: taxes, service charges, locations, hours/holidays, printer maps, KDS screens, payment settings, legal/compliance, branding
   - Developer platform: APIs, webhooks, app keys, OAuth, rate limits, audit, versioning
8) Screen inventory and specs
   - For every screen: purpose, primary actions, UI anatomy, states, validation, empty/edge/error states, accessibility
   - Mobile and tablet responsive specs required for each screen
9) Data model
   - ERD overview; key entities and relationships; multi-tenant boundaries
   - Field-level specs, validation constraints, indexing hints
10) APIs and integration contracts
   - REST/GraphQL endpoints, request/response schemas, idempotency, pagination
   - Webhooks: events, payloads, retries, signatures
11) Non-functional requirements (enterprise-grade)
   - Security: RBAC/ABAC, SSO/SAML/OIDC, MFA, encryption in transit/at rest, secrets
   - Compliance: PCI DSS, GDPR/CCPA, data retention, PII handling, consent
   - Performance: target latencies (p95), throughput, KDS/print <1s target
   - Availability: SLOs/SLAs, HA, DR/RPO/RTO, multi-region
   - Offline-first for POS: local queueing, conflict resolution, sync strategy
   - Observability: logs, metrics, traces, audit trails, anomaly detection
   - Scalability and cost: horizontal scaling, tenant isolation, resource quotas
   - Accessibility: WCAG 2.1 AA; keyboard-only, color contrast, large touch targets
   - Localization: time zones, currencies, tax models, number/date formats
12) Operational playbooks
   - Deployments, migrations, blue/green, feature flags
   - Incident response, on-call runbooks, support tiers
13) Test strategy and acceptance
   - BDD scenarios, smoke/regression packs, performance tests, hardware-in-the-loop
   - UAT checklist and sign-off criteria
14) Assumptions, dependencies, and open questions
15) Traceability matrix linking requirements → screens → APIs → tests

Enterprise constraints (must-haves)
- Commercial/enterprise ready; no feature gaps vs mainstream POS
- All screens fully specified for mobile and tablet
- Multi-tenant by design with strong data isolation
- Meets PCI DSS for card flows; least privilege; auditable changes
- Offline-capable POS with deterministic sync and conflict handling

Style and quality bar
- Be precise, concise, and implementation-oriented
- Cite assumptions explicitly where references lack detail
- Minimize ambiguity; prefer rules, constraints, and examples
- For each feature: include error states, edge cases, and acceptance criteria

Acceptance criteria for the deliverable
- Completeness: covers every category listed above without gaps
- Consistency: terms and flows consistent across sections
- Testability: Given/When/Then criteria per feature/screen
- Mobile/tablet: explicit responsive guidance per screen
- Traceability: matrix included; references linked to sections
- Enterprise NFRs: measurable targets provided (SLOs, performance, security)

Output instructions
- Deliver only the full Markdown content for full-requirements.md
- Do not include meta commentary; produce the document directly

—

Optional next step
If helpful, replace docs/prompts/po-prompt.md with this improved version or tailor it per module.
