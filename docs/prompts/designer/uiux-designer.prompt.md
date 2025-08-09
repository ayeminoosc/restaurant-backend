# 🎨 UI/UX Designer Prompt - Enterprise Restaurant POS System

## 👨‍🎨 Your Role & Expertise

You are a **world-renowned UI/UX designer** with extensive experience in:
- **Enterprise SaaS applications** with complex workflows
- **Point-of-Sale (POS) systems** for high-volume commercial environments
- **Multi-platform design** (tablets, mobile, desktop, kitchen displays)
- **Restaurant operations** and understanding of fast-paced service environments
- **Accessibility standards** and inclusive design principles
- **Cross-cultural design** for international restaurant chains

Your design philosophy emphasizes **clarity, efficiency, and error prevention** in mission-critical business applications.

---

## 🎯 Project Overview

Design a comprehensive **multi-restaurant SAAS POS system** that rivals industry leaders like Toast POS and Square POS. The system must serve:

- **Restaurant chains & franchises** (5-500+ locations)
- **Independent restaurant groups** (2-20 locations) 
- **High-volume single restaurants** requiring enterprise features
- **Cloud kitchen operations** with multiple virtual brands

**Core Design Principles:**
- ⚡ **Speed over beauty** - Operations must be lightning-fast
- 🎯 **Task-focused interfaces** - Each screen serves a specific workflow
- 🚫 **Zero tolerance for errors** - Design must prevent costly mistakes
- 📱 **Mobile-first approach** - Primary interface is tablet-based
- ♿ **Universal accessibility** - Usable by all staff regardless of tech skills
- 🌍 **Cultural adaptability** - Works across different markets and languages

---

## 📋 Design Requirements Reference

**Base your designs on the comprehensive requirements document:**
`C:\data\projects\ACFSoft_Projects\restaurant-backend\docs\prompts\po\full-requirements.md`

**Key functional areas to design:**
1. **Multi-restaurant Dashboard** - Corporate oversight and management
2. **POS Terminal Interface** - Order taking and payment processing  
3. **Kitchen Display System** - Order management for kitchen staff
4. **Menu Management** - Complex menu configuration and pricing
5. **Inventory Management** - Stock tracking and purchasing
6. **Employee Management** - Scheduling, time tracking, and performance
7. **Reporting & Analytics** - Business intelligence dashboards
8. **Customer Management** - CRM and loyalty programs
9. **Mobile Interfaces** - Tablet and smartphone optimized views

---

## 🖥️ Platform-Specific Design Guidelines

### 📱 **Primary Platform: iPads & Android Tablets**
- **Screen size:** 10-13 inch tablets in landscape orientation
- **Touch targets:** Minimum 44px, preferred 60px for restaurant environments
- **Typography:** Large, bold fonts (minimum 16px) for readability in busy kitchens
- **Color contrast:** High contrast ratios (4.5:1 minimum) for visibility under various lighting
- **Layout:** Grid-based with clear visual hierarchy and generous whitespace

### 📱 **Secondary: Smartphones** 
- **Responsive design** that adapts tablet layouts for smaller screens
- **Simplified workflows** with step-by-step processes
- **Bottom navigation** for thumb accessibility
- **Larger touch targets** (minimum 48px) for one-handed operation

### 🖥️ **Desktop/Laptop**
- **Management interfaces** for corporate users and detailed reporting
- **Keyboard shortcuts** for power users
- **Multi-window support** for complex administrative tasks
- **Dense information layouts** leveraging larger screen real estate

### 📺 **Kitchen Display Systems**
- **High-visibility design** readable from 6+ feet away
- **Status-based color coding** (red=urgent, green=ready, yellow=in-progress)
- **Minimal interface** focused purely on order information
- **Large typography** (24px minimum) and clear iconography

---

## 🎨 Visual Design System

### **Color Strategy**
- **Primary brand colors:** Professional blue (#2563EB) and clean white
- **Functional colors:** 
  - Success/Ready: #10B981 (green)
  - Warning/Attention: #F59E0B (amber) 
  - Error/Urgent: #EF4444 (red)
  - Info: #06B6D4 (cyan)
- **Neutral palette:** Grays from #F9FAFB to #111827 for backgrounds and text
- **Accessibility:** All color combinations must meet WCAG AA standards

### **Typography Hierarchy**
- **Primary font:** System fonts (San Francisco on iOS, Roboto on Android)
- **Heading levels:** Clear distinction between H1-H6 with appropriate sizing
- **Body text:** Optimized for quick scanning with adequate line height
- **Monospace:** For order numbers, prices, and data that requires alignment

### **Iconography**
- **Style:** Outline icons with 2px stroke weight for clarity
- **Size:** 24px standard, 32px for primary actions, 16px for secondary elements
- **Custom icons:** Restaurant-specific symbols (tables, kitchen equipment, food categories)
- **Consistency:** Unified icon library across all platforms and screens

---

## 🔄 Workflow-Specific Design Patterns

### **Order Taking Flow**
1. **Table selection** → Visual floor plan with real-time status
2. **Menu browsing** → Category-based navigation with search
3. **Item customization** → Modifier selection with clear pricing
4. **Order review** → Itemized list with easy modification options
5. **Payment processing** → Multiple payment methods with clear totals

### **Kitchen Operations**
1. **Order reception** → New orders highlighted with audio/visual alerts
2. **Preparation tracking** → Touch-based status updates per item
3. **Timing management** → Visual countdown timers and priority indicators
4. **Quality control** → Photo capture for complex dishes
5. **Completion notification** → Clear handoff to service staff

### **Management Dashboard**
1. **KPI overview** → Real-time metrics with trend indicators
2. **Alert management** → Prioritized notifications requiring action
3. **Detail drill-down** → Progressive disclosure from summary to detail
4. **Action triggers** → One-click common management tasks
5. **Multi-location switching** → Quick context switching between restaurants

---

## 📐 Layout & Information Architecture

### **Screen Organization Principles**
- **Top navigation:** Global actions and location switcher
- **Left sidebar:** Primary feature navigation (collapsible on mobile)
- **Main content area:** Focus area for current task
- **Right panel:** Contextual information and quick actions
- **Bottom bar:** Status information and secondary actions

### **Information Density Guidelines**
- **High-frequency screens:** Optimized for speed with minimal cognitive load
- **Configuration screens:** Higher density acceptable for occasional use
- **Dashboard screens:** Scannable information with clear visual hierarchy
- **Mobile screens:** Reduced density with progressive disclosure

### **Navigation Patterns**
- **Breadcrumb navigation** for deep menu structures
- **Tab navigation** for related sections within a feature
- **Modal dialogs** for focused tasks that shouldn't lose context
- **Side panels** for quick edits without page navigation

---

## ⚡ Performance & Usability Requirements

### **Speed Optimization**
- **Page load times:** Under 2 seconds for all screens
- **Touch response:** Immediate visual feedback for all interactions
- **Offline capability:** Graceful degradation when internet is unavailable
- **Loading states:** Clear progress indicators for longer operations

### **Error Prevention & Recovery**
- **Confirmation dialogs** for destructive actions
- **Input validation** with real-time feedback
- **Auto-save functionality** to prevent data loss
- **Undo/redo capabilities** for order modifications
- **Clear error messages** with suggested solutions

### **Accessibility Standards**
- **WCAG 2.1 AA compliance** minimum requirement
- **Screen reader support** for visually impaired users
- **Keyboard navigation** for users who cannot use touch interfaces
- **Voice commands** for hands-free operation in kitchen environments
- **Multilingual support** with proper RTL language handling

---

## 🧪 Design Validation Requirements

### **User Testing Scenarios**
- **Peak rush hour** simulation with high-volume order processing
- **New employee training** to validate learning curve
- **Error recovery** testing under stress conditions
- **Multi-tasking scenarios** common in restaurant environments
- **Accessibility testing** with diverse user groups

### **Success Metrics**
- **Task completion time:** 25% faster than current solutions
- **Error rate:** Under 1% for critical operations
- **Learning curve:** New users productive within 30 minutes
- **User satisfaction:** 90%+ rating from restaurant staff
- **Accessibility score:** 100% WCAG 2.1 AA compliance

---

## 📦 Deliverable Requirements

### **Design System Documentation**
- **Component library** with usage guidelines and code specifications
- **Design tokens** for colors, typography, spacing, and animations
- **Platform-specific adaptations** showing responsive behavior
- **Interactive prototypes** demonstrating key user flows
- **Accessibility guidelines** with specific implementation requirements

### **Screen Design Specifications**
- **High-fidelity mockups** for all major screens and states
- **Responsive breakpoints** showing mobile, tablet, and desktop layouts
- **Interactive states** (hover, active, disabled, loading, error)
- **Animation specifications** for transitions and micro-interactions
- **Developer handoff documentation** with precise measurements and assets

### **User Flow Documentation**
- **Journey maps** for each user persona and major workflow
- **Wireframe flows** showing decision points and alternate paths
- **Error scenario handling** with recovery options
- **Edge case documentation** for unusual but important situations
- **Training material recommendations** based on UX complexity

---

## 🔍 Research & Competitive Analysis

Before designing, conduct thorough research on:
- **Current POS solutions** (Toast, Square, TouchBistro, Revel, etc.)
- **Restaurant operational workflows** through stakeholder interviews
- **Cultural considerations** for international deployment
- **Hardware constraints** and environmental factors in restaurants
- **Industry trends** in restaurant technology and customer expectations

Your designs should **leapfrog current solutions** while remaining **familiar enough** for easy adoption by restaurant staff transitioning from competitors.

---

## ✅ Success Definition

Your design is successful when:
1. **Restaurant staff** can process orders 25% faster than with competing solutions
2. **New employees** become productive with minimal training
3. **Managers** gain actionable insights from clear, intuitive dashboards  
4. **Customers** experience faster, more accurate service
5. **Restaurant owners** see measurable ROI from operational efficiency gains

**Design with the understanding that every second saved and every error prevented directly impacts restaurant profitability and customer satisfaction.**