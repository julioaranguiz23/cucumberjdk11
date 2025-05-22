Feature: TC001_Validar inicio de sesión del usuario

  @funcional @CasoADM0266-8
  Scenario: El usuario ingresa al modulo de riesgos
    Given El usuario esta en el Home Page y hace click en Mi Portal
    When El usuario ingresa las credenciales como usuario "TestGroup1" y contrasena "TestGroup1"
    And El usuario hace click en Ingresar
    Then El usuario ingresa al modulo de Gestor de Riesgos
