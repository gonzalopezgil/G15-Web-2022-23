echo "[+] Bienvenido a la instalación inicial del servidor: $HOSTNAME"

echo "[+] Instalando paquetes necesarios..."
sudo apt install maven -y > /dev/null && echo -e "\t[-] Maven instalado correctamente" || echo -e "\t[!] Error al instalar maven"

echo -e "[+] Instalando dependencias del proyecto backend..."
cd backend
mvn install -DskipTests > /dev/null 2>/dev/null && echo -e "\t[-] Dependencias instaladas correctamente" || echo -e "\t[!] Error al instalar las dependencias de Maven"
cd ..

echo -e "[+] Instalando dependencias del proyecto frontend..."
    cd frontend
sudo npm install @angular/cli -g >/dev/null 2> /dev/null && echo -e "\t[-] Dependencias instaladas correctamente" || echo -e "\t[!] Error al instalar las dependencias de Angular"
cd ..

echo "[+] Instalación finalizada, para ejecutar los servidores con los comandos:"
echo -e "\t[-] cd frontend && npm start --prefix frontend"
echo -e "\t[-] cd backend && mvn spring-boot:run"