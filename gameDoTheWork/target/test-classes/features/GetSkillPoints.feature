# language: en

  #DONE
  #- World
  #- Location
  #- Find Item in a location
  #- Pick up item
  #- Lookaround
  #- Storing in backpack
  #- Open backpack
  #- Equip equipment
  #- Fail to equip equipment
  #- Close backpack
  #- Go to another Location
  #- Interaction menu and Event handling
  #- Npc interaction (Approach, Talk, Battle, Trade, Approached by hostile NPC, Loot)
  #- Trade (Buy and Sell)
  #- Faction change
  #- Rewards
  #- Battle-system (Attack, Block, Item, Run, Special attack)
  #- Matrix movement (Go and Look)
  #- Die
  #- End game
  #- Level up
  #- Skill points
  #- Quest
  #- Backpack transfer to new player
  #- Time Counter

Feature:

  Background:
    Given A player exists

  Scenario: Get Skill points
    Given I level up
    When I get a new level
    Then I get 3 new Skill points