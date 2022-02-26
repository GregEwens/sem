# USE CASE: <number> <the name should be the goal as a short active verb phrase>

## CHARACTERISTIC INFORMATION

### Goal in Context

As *a member of the organisation* I want to *produce a country report showing the top N countries in a continent where N
is provided* so that *I may support the organisation with accurate data.*


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

1. A member of the organisation requests data on country population in the world, specifying the continent to filter by
   and the number of results to show.
2. The user of the system takes note of who the member of the organisation is.
3. The user of the system extracts the population data of country populations of the specified continent, ordered high to low.
4. The user of the system supplies this report to the member of the organisation.

## EXTENSIONS

1. **User specifies "0" for the number of results to show**: Report is created with 0 rows and the scenario ends
2. **User specifies a number larger than the number of countries in the world**: The number of rows will be less
   than the specified amount.
3. **User specifies a continent that does not exist, e.g.  a misspelling**: Report is created with 0 rows and the scenario ends

## SUB-VARIATIONS

none

## SCHEDULE

**DUE DATE**: Sprint 2