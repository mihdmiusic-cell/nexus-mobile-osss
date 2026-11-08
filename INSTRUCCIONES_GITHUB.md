# NEXUS HOME — APK sin Android Studio

Este paquete es un **launcher Android experimental**, NO una ROM que sustituya Android.

## Subir a GitHub
1. Inicia sesión en https://github.com y pulsa **New repository**.
2. Ponle nombre `nexus-mobile-os`, selecciona **Private** (recomendado) y crea el repositorio.
3. En el repositorio, selecciona **Add file > Upload files**.
4. **Extrae primero este ZIP** y sube el CONTENIDO de la carpeta `NEXUS_MOBILE_OS_GitHub_Actions`, incluyendo `.github/workflows/build-apk.yml`. Es imprescindible mantener la estructura de carpetas. En Windows, la carpeta `.github` puede aparecer oculta; activa mostrar elementos ocultos.
5. Confirma con **Commit changes**.
6. Abre la pestaña **Actions**, elige **Compilar Nexus Home APK** y pulsa **Run workflow** (si no se ejecuta automáticamente).
7. Espera a que termine con marca verde. Abre la ejecución y, al final, descarga el artefacto `NEXUS_HOME_Purple_Edition_APK`.
8. Descomprime el artefacto: contiene `app-debug.apk`.

## Probar
Primero en un teléfono secundario o emulador. Para instalar en el Motorola, transfiere `app-debug.apk`, ábrelo y confirma la instalación únicamente si confías en el proyecto. No desbloquees el bootloader ni flashees nada. Para volver al inicio de Motorola, cambia la aplicación de inicio predeterminada en Ajustes.

## Limitaciones
No está compilado ni probado en este entorno. Si Actions falla, comparte el texto del paso rojo para corregirlo. Google Play y WhatsApp son las aplicaciones existentes del teléfono, no forman parte del paquete. El diseño es aproximado y no idéntico píxel por píxel a la referencia.
