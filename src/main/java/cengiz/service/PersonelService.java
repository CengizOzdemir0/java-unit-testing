package cengiz.service;


import cengiz.dto.PersonelDto;
import cengiz.exception.BaseException;


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

}
