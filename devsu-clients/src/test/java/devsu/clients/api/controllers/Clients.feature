Feature: Get test for bankproducts by id
  Background:
    * url 'http://localhost:9090/api/v1'

  Scenario: Post new client
    Given path '/clientes'
    And request {"name": "Erick Lizana", "address": "Lima 123", "phone": "83467373", "password": "12134hgf" }
    And header Content-Type = 'application/json'
    When method POST
    Then status 201

  Scenario: Update the created client
    Given path '/clientes/1'
    And request {"name": "New John Doe"}
    And header Content-Type = 'application/json'
    When method PUT
    Then status 200

  Scenario: Get non-existent client
    Given path 'clientes/9999'
    And header Accept = 'application/json'
    When method GET
    Then status 400
    And match response.status == 400

  Scenario: Delete the created client
    Given path 'clientes/1'
    And header Accept = 'application/json'
    When method DELETE
    Then status 200
