package br.com.mercadolivre.storage_implementation.parte_02.pratica_integradora_01.service;

import br.com.mercadolivre.storage_implementation.parte_02.pratica_integradora_01.exception.JewelNotFoundException;
import br.com.mercadolivre.storage_implementation.parte_02.pratica_integradora_01.model.Jewel;
import br.com.mercadolivre.storage_implementation.parte_02.pratica_integradora_01.repository.JewelRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

public class JewelServiceUnityTests {

  private JewelRepository jewelRepository;
  private JewelService jewelService;

  @BeforeEach
  public void setUp() {
    this.jewelRepository = Mockito.mock(JewelRepository.class);
    this.jewelService = new JewelService(this.jewelRepository);
  }

  @AfterEach
  public void reset() {
    this.jewelRepository = null;
  }

  @Test
  @DisplayName("Test if listJewels method lists all jewels on jewel repository")
  public void testIfListMethodListsAllJewels() {

    // SETUP
    List<Jewel> expectedJewelsList = List.of(Jewel.builder().weight(0.0).build(), Jewel.builder().carats(17.0).build());

    Mockito.when(this.jewelRepository.findAll()).thenReturn(expectedJewelsList);

    // ACT
    List<Jewel> responseJewelsList = this.jewelService.listJewels();

    // ASSERT
    Assertions.assertEquals(expectedJewelsList, responseJewelsList);
  }

  @Test
  @DisplayName("Test if find by id returns the right jewel")
  public void testIfFindByIdReturnRightJewel() {
    // SETUP
    Jewel expectedJewel = Jewel.builder().id(1L).weight(12.0).carats(18.0).build();

    Mockito.when(this.jewelRepository.findById(1L)).thenReturn(Optional.of(expectedJewel));

    // ACT
    Jewel responseJewel = this.jewelService.findJewelById(1L);

    // ASSERT
    Assertions.assertEquals(expectedJewel, responseJewel);
  }

  @Test
  @DisplayName("Test if find by with not found id raises right exception")
  public void testIfFindByIdRaisesRightException() {
    // SETUP
    Mockito.when(this.jewelRepository.findById(Mockito.any())).thenReturn(Optional.empty());

    // ACT / ASSERT
    Assertions.assertThrows(JewelNotFoundException.class, () -> this.jewelService.findJewelById(1L));
  }

  @Test
  @DisplayName("Test if add jewel return the right id")
  public void testIfAddJewelReturnsRightId() {
    // SETUP
    Jewel expectedJewel = Jewel.builder().id(123L).build();

    Mockito.when(this.jewelRepository.save(Mockito.any())).thenReturn(expectedJewel);

    // ACT
    Long addedJewelId = this.jewelService.addJewel(Jewel.builder().build());

    // ASSERT
    Assertions.assertEquals(expectedJewel.getId(), addedJewelId);
  }

  @Test
  @DisplayName("Test if delete existent jewel calls delete method")
  public void testIfDeleteExistentJewelCallsDeleteMethod() {
    // SETUP
    Mockito.when(this.jewelRepository.findById(Mockito.any())).thenReturn(Optional.of(Jewel.builder().build()));

    // ACT
    this.jewelService.deleteJewel(1L);

    // ASSERT
    Mockito.verify(this.jewelRepository, Mockito.times(1)).delete(Mockito.any());
  }

  @Test
  @DisplayName("Test if delete not existent jewel doesn't call delete method")
  public void testIfDeleteNotExistentJewelDoesntCallDeleteMethod() {
    // SETUP
    Mockito.when(this.jewelRepository.findById(Mockito.any())).thenReturn(Optional.empty());

    // ACT
    this.jewelService.deleteJewel(1L);

    // ASSERT
    Mockito.verify(this.jewelRepository, Mockito.times(0)).delete(Mockito.any());
  }
}
