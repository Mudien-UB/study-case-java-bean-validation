# Belajar Java Bean Validation menggunakan SpringBoot

## Teknologi :
1. Java 21
2. Apache Maven 3.8.7
3. Springboot 3.5.5

## Study Case yang akan dikerjakan

1. UserRegistration

   Field: username, email, password, confirmPassword, age, address.<br/>
   Fitur yang dipakai:
    ```
    Custom constraint → @StrongPassword, @CaseInsensitiveEmail.
    Nested validation → @Valid Address.
    Constraint composition → @StrongPassword gabungan dari @NotBlank, @Size, dsb.
    Class-level constraint → password == confirmPassword.
    ``` 

2. Event Management

   Field: eventName, startDate, endDate, maxParticipants.<br/>
   Fitur yang dipakai:

   ```
    Class-level constraint → startDate < endDate.
    Group sequence → validasi berurutan (misalnya @NotBlank dulu baru validasi business rule).
    I18N messages → error bisa tampil dalam bahasa Indonesia/English.
   ```
     
3. Bank Transaction
 
   Method: transfer(String fromAccount, String toAccount, double amount).<br/>
   Fitur yang dipakai:

   ```
    Method validation → validasi parameter langsung di service method.
    Cross-parameter constraint → fromAccount != toAccount.
    GlobalExceptionHandler → tangkap semua ConstraintViolationException dan balikin JSON.
   ```
   
---

> Dont Forget a Cup of Coffee Today
