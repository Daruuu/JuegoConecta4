#script to automate my repository update with MAKEFILE
run:
	git status
	git add .
		@echo "Add the commit message:"; \
	read COMMITMESSAGE; \
	git commit -m " $$COMMITMESSAGE "
		@echo "Enter the name of branch (main|master)"; \
	read BRANCH; \
	git push origin $$BRANCH; \
		echo "<<<<<<<<<<--- REPOSITORY UPDATED SUCCESSFUL!! --->>>>>>>>>>"
	git log -n 3
