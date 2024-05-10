import os

mvn = "\"C:/Program Files/JetBrains/IntelliJ IDEA 2023.3.4/plugins/maven/lib/maven3/bin/mvn\""
os.system(f"{mvn} clean package")

project_dir = "C:/Users/Mmd4j/IdeaProjects/KnockForce"
file_name = "KnockForce-1.0-SNAPSHOT.jar"
build_path = f"{project_dir}/target/{file_name}"
server_path = f"{project_dir}/test_server"
plugin_path = f"{server_path}/plugins/{file_name}"
script_path = f"{server_path}/start.bat"
if os.path.exists(plugin_path):
    os.remove(plugin_path)
os.rename(build_path, plugin_path)
os.chdir(server_path)
os.system(script_path)
