package cengiz.service;

import static org.junit.jupiter.api.Assertions.*;

import cengiz.dto.PersonelDto;
import cengiz.exception.BaseException;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-10-03
 */

@SpringBootTest
class PersonelServiceTest {


  @InjectMocks
  private PersonelService personelService;


  @Test
  void When_KullaniciAdiNull_Expect_HataMesaji() {
    PersonelDto dto = new PersonelDto();
    dto.setKullaniciSoyadi("Ozdemir");
    dto.setKurumId(1);
    dto.setBaslangicTarihi(LocalDateTime.now());
    dto.setBitisTarihi(LocalDateTime.now().plusDays(2));

    BaseException exception = assertThrows(BaseException.class, () -> personelService.save(dto));
    assertEquals("kullanici adi bos olamaz", exception.getMessage());
  }

  @Test
  void When_KullaniciSoyadiNull_Expect_HataMesaji() {
    PersonelDto dto = new PersonelDto();
    dto.setKullaniciAdi("Cengiz");
    dto.setKurumId(1);
    dto.setBaslangicTarihi(LocalDateTime.now());
    dto.setBitisTarihi(LocalDateTime.now().plusDays(2));

    BaseException exception = assertThrows(BaseException.class, () -> personelService.save(dto));
    assertEquals("kullanici soyadi bos olamaz", exception.getMessage());
  }

  @Test
  void When_KurumIdNull_Expect_HataMesaji() {
    PersonelDto dto = new PersonelDto();
    dto.setKullaniciAdi("Cengiz");
    dto.setKullaniciSoyadi("Ozdemir");
    dto.setBaslangicTarihi(LocalDateTime.now());
    dto.setBitisTarihi(LocalDateTime.now().plusDays(2));

    BaseException exception = assertThrows(BaseException.class, () -> personelService.save(dto));
    assertEquals("kurum id bos olamaz", exception.getMessage());
  }

  @Test
  void When_AllFieldsValid_Expect_Success() {
    PersonelDto dto = new PersonelDto();
    dto.setKullaniciAdi("Cengiz");
    dto.setKullaniciSoyadi("Ozdemir");
    dto.setKurumId(1);
    dto.setBaslangicTarihi(LocalDateTime.now());
    dto.setBitisTarihi(LocalDateTime.now().plusDays(2));

    PersonelDto savedDto = personelService.save(dto);
    assertNotNull(savedDto);
    assertEquals("Cengiz", savedDto.getKullaniciAdi());
  }
  @Test
  void When_GetByIdWithInvalidId_Expect_Exception() {
    Integer invalidId = -1;

    BaseException exception = assertThrows(BaseException.class, () -> personelService.getById(invalidId));
    assertEquals("Gecersiz ID", exception.getMessage());
  }

  @Test
  void When_GetByIdWithNullId_Expect_Exception() {
    Integer nullId = null;

    BaseException exception = assertThrows(BaseException.class, () -> personelService.getById(nullId));
    assertEquals("Gecersiz ID", exception.getMessage());
  }
}