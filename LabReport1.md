# Week 1 - Markdown, URL's, Paths, and the Filesystem
**1) Example of using the command with no arguments :**\
**cd :**\
When we cd without an argument we stay in the same directory.\
![Image](https://cdn.discordapp.com/attachments/1095905756118778001/1161138888396509277/Screenshot_2023-10-09_at_8.10.51_PM.png?ex=653735db&is=6524c0db&hm=dcd5b0a6d1e617c17953044d579bb9c33402ea2a5da28c736c1a3c7e676a1bea&)

**ls:**\
When we ls without an argument, it lists the set of folders in the current directory.\
![Image](https://cdn.discordapp.com/attachments/1095905756118778001/1161141164737564722/Screenshot_2023-10-09_at_8.20.10_PM.png?ex=653737fa&is=6524c2fa&hm=23224a70c0222f9305c8213565f1e022835073c8c5fc00af8d9085e4aaaf58c8&)

**cat:**\
When we cat without an argument, it prints an empty string since we haven't passed in any file whose contents need to be printed.\
![Image](https://cdn.discordapp.com/attachments/1095905756118778001/1161141378223460403/Screenshot_2023-10-09_at_8.21.03_PM.png?ex=6537382d&is=6524c32d&hm=98b0c7d0753e20f5acc82ca296db1a123a500637f7c4be698edf37d886761b2f&)

**2) Example of using the command with a path to a directory as an argument :**\
**cd :**\
When we cd using a path to a directory as an argument we get into that directory. For eg in this case, we go from the main directory to the Downloads directory.\
![Image](https://cdn.discordapp.com/attachments/1095905756118778001/1161142346793111623/Screenshot_2023-10-09_at_8.24.49_PM.png?ex=65373914&is=6524c414&hm=3aa703700732603b322a1b9983b79225a0099038d8ca96120b1af544ea848ff3&)

**ls :**\
When we ls with a path to a directory as an argument, it prints the list of folders in the directory which we pass as an argument.\
![Image](https://cdn.discordapp.com/attachments/1095905756118778001/1161143004208304148/Screenshot_2023-10-09_at_8.27.29_PM.png?ex=653739b1&is=6524c4b1&hm=4a3edd4dd03e7085aa3cedec3a1fa78aa801a34198b587de46e5fb1478af61fe&)

**cat: **\
When we cat with a path to a directory as an argument, it throws an error. Since cat only prints contents of files and not contents of a directory. It throws an error saying "Is a directory"\
![Image](https://cdn.discordapp.com/attachments/1095905756118778001/1161143399412412436/Screenshot_2023-10-09_at_8.29.04_PM.png?ex=65373a0f&is=6524c50f&hm=d4011eb0c538f9d98c038842ac66ba7240bbf2073e7aa92b14f4a77f90901c12&)

**3) Example of using the command with a path to a file as an argument :**\
**cd :**\
When we cd with a path to a file as an argument it doesn't work since cd changes only to directories and not to files and hence, we get an error saying "Not a directory" \
![Image](https://cdn.discordapp.com/attachments/1095905756118778001/1161145126492569701/Screenshot_2023-10-09_at_8.35.59_PM.png?ex=65373bab&is=6524c6ab&hm=cdb2b7c85fb111b86cc3d1cb437a094aa1b4f153cf6747ed5ad6717507ec68b9&)

**ls :**\
When we ls with a path to a file as an argument it just prints the path of the file as the output \
![Image](https://cdn.discordapp.com/attachments/1095905756118778001/1161145356873109616/Screenshot_2023-10-09_at_8.36.51_PM.png?ex=65373be2&is=6524c6e2&hm=0030600b7891f7a2a94cd0eeded33cf04e42a9bdcf037561b00ed588f1495346&)

**cat :**\
When we cat with a path to a file as an argument, it prints the contents of the file which was passed as the argument\
![Image](https://cdn.discordapp.com/attachments/1095905756118778001/1161146465381531738/Screenshot_2023-10-09_at_8.41.08_PM.png?ex=65373cea&is=6524c7ea&hm=ae9311363ed339b97c49a189671dd6257b4d8ad6da8668c7a372e0b74f759aa2&)








