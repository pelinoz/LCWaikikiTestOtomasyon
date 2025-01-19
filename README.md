
# LC Waikiki Yazılım Test Uzmanlığı Bootcamp Bitirme Projesi

Bu proje, **Patika.dev & LC Waikiki Yazılım Test Uzmanlığı Bootcamp**'inde verilen bitirme projesi kapsamında gerçekleştirilmiştir. Proje, bir web otomasyon testi senaryosunu içermekte ve aşağıdaki gereksinimleri karşılamaktadır.

## Kullanılacak Teknolojiler

- Selenium
- Java
- TestNG
- Maven

## Otomasyon Senaryosu

1. **Giriş Yapma**:
   - [LC Waikiki](https://www.lcw.com/) adresine gidilir.
   - "Giriş Yap" butonuna tıklanır.
   - Geçerli bir email ve şifre ile giriş yapılır.

2. **Kategoriler ve Filtreleme**:
   - **Çocuk & Bebek** kategorisi seçilir.
   - **Kız Çocuk (6-14 Yaş)** kategorisi seçilir.
   - **Mont ve Kaban** alt menüsü seçilir.
   - Filtreleme işlemleri:
     - *"Beden"* filtresinden *"5-6"*, *"6"* ve *"6-7"* yaş seçilir.
     - *"Renk"* filtresinden *"bej"* seçilir.

3. **Ürün Sıralama**:
   - Sağ üst köşedeki *"Sırala"* combobox'ından *"En çok satanlar"* seçilir.
   - Ürünler sıralanır ve kontrol edilir.

4. **Ürün Seçimi ve Sepet İşlemleri**:
   - İlk satırdaki 4. ürünün detayına gidilir.
   - Tükenmemiş bir beden seçilir ve sepete eklenir.

5. **Favorilere Ekleme ve Sepet Kontrolleri**:
   - Ürün favorilere eklenir.
   - *"Sepetim"* ekranına gidilir ve ürün bilgileri doğrulanır:
     - Ürün adı
     - Renk
     - Adet
     - Tutar

6. **Sipariş Adımları**:
   - "Ödeme adımına geç" butonuna tıklanır.
   - Teslimat yöntemi "Adrese Teslimat" olarak seçilir.
   - Ödeme yöntemi "Banka/Kredi Kartı" olarak belirlenir.

7. **Favoriler Doğrulaması**:
   - Favoriler ekranında, daha önce favorilere eklenen ürünün listelendiği kontrol edilir.


## Kurulum


#### 1. **Gerekli Araçları Yükleyin:**
- **Java Development Kit (JDK):** Java 11 veya daha üstü bir sürümün yüklenmiş olması gerekir.
- **Maven:** Maven, proje bağımlılıklarını yönetmek için kullanılır.
- **IDE:** IntelliJ IDEA, Eclipse veya tercih ettiğiniz bir IDE'yi yükleyin.
- **ChromeDriver:** Tarayıcınızın sürümüyle uyumlu bir ChromeDriver indirin ve `src/test/resources` dizinine yerleştirin.

#### 2. **Proje Kaynak Kodlarını Klonlayın:**
```bash
git clone https://github.com/pelinoz/LCWaikikiTestOtomasyon.git
```

#### 3. **Bağımlılıkları Yükleyin:**
Proje bağımlılıklarını Maven yardımıyla yükleyin:
```bash
mvn clean install
```

#### 4. **Test Bilgilerinin Doğru Olduğundan Emin Olun:**
```properties
url=https://www.lcw.com
browser=chrome
email= username
password= password
```

#### 5. **Testleri Çalıştırın:**
Testleri Maven yardımıyla çalıştırın:
```bash
mvn test
```

#### 6. **Allure Raporlarını Oluşturun:**
Allure raporlarını görüntülemek için aşağıdaki komutu çalıştırın:
```bash
allure serve
```

### **Allure Raporlama**

#### **Testlerin Başarı ve Başarısızlık Durumu**
Testlerin başarı veya başarısızlık durumu, ekran görüntüsü ile birlikte detaylı bir şekilde raporlanır.

#### **Test Adımları**
Her bir test adımı, `@Step` anotasyonu ile detaylandırılmıştır ve Allure raporlarında görsel olarak sunulur.

#### **Hata Durumları**
Hata durumlarında, otomatik olarak ekran görüntüsü alınır ve rapora eklenir. Bu özellik, hataların daha kolay analiz edilmesini sağlar.



