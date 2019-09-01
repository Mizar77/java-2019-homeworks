
# 作业提交流程

1. 注册github账号（假设账户名称为`javalover`。若已注册则跳过此步骤）；
2. 用此账号登陆github（若已登陆则跳过此步骤）；
3. fork本仓库（ https://github.com/njuics/java-2019-homeworks ）至自己账户，仓库url为（ https://github.com/javalover/java-2019-homeworks );
4. 在你的本机clone你所fork的仓库(`javalover/java-2019-homeworks`）；
	1. 对于简单作业（在我们讲使用maven/gradle等构建工具开发java工程之前），请使用以下步骤
		1. 在`javalover/java-2019-homeworks`进入当前作业目录，例如`java-2019-homeworks/1-LanguageBasics`目录，新建子目录`张三-151220001`,此处“张三”和“151220001” 分别替换真实姓名和学号;
		2. 将你写好的代码文件拷贝到该目录下，然后执行`git add .`, `git commit -a` 和`git push`
	2. 对于复杂作业和最后的大作业（在我们讲使用maven/gradle等构建工具开发java工程之后），请使用以下步骤
		1. 在`javalover`账户下新建一个代码仓库，例如`myhomework`；
		2. 在`myhomework`下编写代码，代码使用`git add .`, `git commit -a` 和`git push`等命令进行管理；
		3. 在`javalover/java-2019-homeworks`进入当前作业目录，例如`java-2019-homeworks/1-LanguageBasics`，执行`git submodule add https://github.com/javalover/myhomework 张三-151220001`,此处“张三”和“151220001” 分别替换真实姓名和学号。  
5. 在`javalover/java-2019-homeworks`上创建“Pull request"，然后在QQ群内联系助教请其审核后合并。