echo -e "HERRAMIENTA DE CLONACIÓN DE REPOSITORIOS"
echo -e "======================================="
echo -e "[+] Configuración de clave ssh"
if [ ! -f ~/.ssh/id_rsa ]; then
    echo -e "\t[-] Generando clave ssh..."
    ssh-keygen
    echo -e "\t[-] Clave ssh generada correctamente"
fi
echo -e "\t[-] Copie la clave ssh e introduzcala en su cuenta de github (Settings->SSH and GPG keys->New SSH key)"
cat ~/.ssh/id_rsa.pub
echo -e "\t[-] Pulse enter cuando la clave ssh haya sido introducida en su cuenta de github"
read
echo -e "[+] Clonando repositorio..."
git clone git@github.com:gonzalopezgil/G15-Web-2022-23.git
echo -e "[+] Repositorio clonado correctamente"

echo -e "[+] Configurando cuenta de github..."
echo -e "\t[-] Introduzca su nombre de usuario de github:"
read username
echo -e "\t[-] Introduzca su email de github:"
read email
git config --global user.name $username && git config --global user.email $email && echo -e "\t[-] Cuenta de github configurada correctamente" || echo -e "\t[!] Error al configurar la cuenta de github..."

echo -e "[+] Ejecutando script de instalación..."
cd G15-Web-2022-23
./devops/startup.sh
echo -e "[+] Script de instalación ejecutado correctamente"

