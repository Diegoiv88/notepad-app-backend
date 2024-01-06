#!/bin/bash

echo "Iniciando la configuración y ejecución de Notepad-App..."

# Instalación de Node.js y npm (si no están instalados)
if ! command -v node &> /dev/null || ! command -v npm &> /dev/null; then
    echo "Node.js y/o npm no están instalados. Instalando..."
    # Comando de instalación de Node.js y npm (ajústalo según tu entorno)
    # Por ejemplo, para macOS puedes usar Homebrew: brew install node
    # Para Linux puedes usar el administrador de paquetes de tu distribución.
fi

# Instalación de Java (si no está instalado)
if ! command -v java &> /dev/null || ! command -v javac &> /dev/null; then
    echo "Java no está instalado. Instalando..."
    # Comando de instalación de Java (ajústalo según tu entorno)
    # Por ejemplo, para macOS puedes usar Homebrew: brew install openjdk@17
    # Para Linux puedes usar el administrador de paquetes de tu distribución.
fi

# Instalación de MySQL Server (si no está instalado)
if ! command -v mysql &> /dev/null; then
    echo "MySQL Server no está instalado. Instalando..."
    # Comando de instalación de MySQL Server (ajústalo según tu entorno)
    # Por ejemplo, para macOS puedes usar Homebrew: brew install mysql
    # Para Linux puedes usar el administrador de paquetes de tu distribución.
fi

# Clonar el repositorio
echo "Clonando el repositorio..."
git clone https://github.com/DiegoIv88/notepad-app-backend.git

# Configuración del backend
echo "Configurando el backend..."
cd notepad-app/backend
# (Añade aquí cualquier comando adicional necesario para configurar el backend)

# Puedes agregar comandos para configurar la base de datos u otras configuraciones
./mvnw clean install

# Ejecutar el backend en segundo plano
./mvnw spring-boot:run &



