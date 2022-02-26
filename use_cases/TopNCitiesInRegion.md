# USE CASE: #13 Top N Cities In Region

## CHARACTERISTIC INFORMATION

### Goal in Context

As a **member of the organisation** I want to **produce a city report showing the top N populated cities in a region 
where N is provided** so that **I may support the organisation with accurate data.**


### Scope

Company

### Level

Primary task

### Preconditions

The Database contains all the current population data of the countries in the world.

### Success End Condition

A report is available for the member of the organisation to view and support the organisation with.

### Failed End Condition

No report or an inaccurate report is produced.

### Primary Actor

The user of the system.

### Trigger

The organisation requires information that the user of the system supplies.

## MAIN SUCCESS SCENARIO

1. A member of the organisation requests data on cities of the world for a specified region, specifying the number of 
   results to show.
2. The user of the system takes note of who the member of the organisation is.
3. The user of the system extracts the data for cities of the world for the specified region, ordered high to low.
4. The user of the system supplies this report to the member of the organisation.

## EXTENSIONS

1. **User specifies "0" for the number of results to show**: Report is created with 0 rows and the scenario ends
2. **User specifies a number larger than the number of cities in the world**: The number of rows will be less
   than the specified amount.
3. **User specifies a region that does not exist, e.g.  a misspelling**: Report is created with 0 rows and the scenario ends

## SUB-VARIATIONS

none

## SCHEDULE

**DUE DATE**: Sprint 2