package br.com.mercadolivre.storage_implementation.service;

import br.com.mercadolivre.storage_implementation.model.Jewel;
import br.com.mercadolivre.storage_implementation.repository.JewelRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.util.List;

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
    public void testIfFindByIdReturnRightJewel(){
    }

    @Test
    @DisplayName("Test if find by with not found id raises right exception")
    public void testIfFindByIdRaisesRightException(){
    }


    @Test
    @DisplayName("Test if add jewel return the right id")
    public void testIfaddJewelReturnsRightId(){
    }

    @Test
    @DisplayName("Test if delete existent jewel calls delete method")
    public void testIfDeleteExistentJewelCallsDeleteMethod(){
    }

    @Test
    @DisplayName("Test if delete not existent jewel doesn't call delete method")
    public void testIfDeleteNotExistentJewelDoesntCallDeleteMethod(){
    }
}
