package cengiz.service;


import cengiz.dto.PersonelDto;
import cengiz.exception.BaseException;


import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class PersonelService {


  /**
   * This method saves the person details.
   * <p>
   * To see the unit tests for this method, check {@link PersonelServiceTest}.
   * <p>
   * Example test cases:
   * <ul>
   *   <li>When {@code kullaniciAdi} is null, expect a "kullanici adi bos olamaz" error.</li>
   *   <li>When {@code kullaniciSoyadi} is null, expect a "kullanici soyadi bos olamaz" error.</li>
   *   <li>When {@code kurumId} is null, expect a "kurum id bos olamaz" error.</li>
   * </ul>
   *
   */

  public PersonelDto save(PersonelDto personelDto) {
    if (personelDto.getKullaniciAdi() == null) {
      throw new BaseException("kullanici adi bos olamaz");
    }
    if (personelDto.getKullaniciSoyadi() == null) {
      throw new BaseException("kullanici soyadi bos olamaz");
    }
    if (personelDto.getKurumId() == null) {
      throw new BaseException("kurum id bos olamaz");
    }
    return personelDto;
  }

  public PersonelDto getById(Integer id) {
    if (id == null || id <= 0) {
      throw new BaseException("Gecersiz ID");
    }
    // Örnek bir personelDto döndürüyoruz.
    PersonelDto personelDto = new PersonelDto();
    personelDto.setKullaniciAdi("Cengiz");
    personelDto.setKullaniciSoyadi("Ozdemir");
    personelDto.setKurumId(id);
    personelDto.setBaslangicTarihi(LocalDateTime.now());
    personelDto.setBitisTarihi(LocalDateTime.now().plusDays(2));

    return personelDto;
  }

}
