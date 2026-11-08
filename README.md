# NEXUS MOBILE OS — Purple Edition

## Qué contiene
Proyecto Android Studio **Nexus Home 0.1.0**: launcher experimental con diseño oscuro y detalles violeta, efecto cristal, escritorio, bloqueo visual, centro de control, ajustes, lista de apps instaladas, notas locales y calculadora.

**NO es una ROM, NO sustituye Android y NO está probado en un Motorola real.** El diseño es una aproximación interactiva a la imagen de referencia, no una reproducción pixel a pixel. El bloqueo es visual y NO sustituye la pantalla de bloqueo segura de Android. Los ajustes de conectividad abren los paneles oficiales de Android.

## Cómo compilar en Windows 11
1. Instala Android Studio desde https://developer.android.com/studio (gratuito).
2. Descomprime este ZIP y en Android Studio pulsa **Open** y selecciona `NEXUS_MOBILE_OS_Purple_Edition`.
3. Espera a que Gradle descargue sus dependencias (requiere internet durante la preparación). Si Android Studio solicita instalar Android SDK 35, acepta.
4. En **Build > Build Bundle(s) / APK(s) > Build APK(s)** compila la aplicación.
5. Encuentra `app/build/outputs/apk/debug/app-debug.apk`.
6. Para probarlo primero, usa un emulador Android. Después puedes copiar el APK a tu móvil e instalarlo con autorización de Android. Al pulsar Inicio, Android puede ofrecer Nexus Home como launcher; puedes volver al launcher de Motorola desde Ajustes > Apps > Aplicaciones predeterminadas > Aplicación de inicio.

## Importante
- No requiere base de datos ni servidor.
- No incorpora Play Store: utiliza las apps ya instaladas en el teléfono, incluida Play Store si el Motorola la tiene.
- No requiere desbloquear el bootloader ni flashear el teléfono.
- Se puede desinstalar como una app normal.
- No hay Gradle Wrapper binario incluido; Android Studio puede gestionar la sincronización usando su Gradle integrado o configurado.
- La compilación **no ha podido verificarse aquí** porque este entorno no dispone de Android SDK/Gradle.
