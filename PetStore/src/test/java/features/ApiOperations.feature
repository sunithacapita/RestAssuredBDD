Feature: Verify getPetsByStatus method  of Pet store
  Scenario: Finds number of pets available with the name doggie
    Given The petstore api accessed for getstatus of pets
    When  I perform get operation for FindByStatus
    Then  validate how many "doggie" are in "available" status