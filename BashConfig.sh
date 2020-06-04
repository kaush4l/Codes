
alias ll="ls -ltr"
alias .="open ."
alias ..="cd .."
alias ...="cd ../.."
alias gb="git branch"
alias gc="git checkout"
alias gp="git pull"
alias gpr="git pull --rebase"
alias gd="git diff"
alias gs="git status"
alias gpru="git remote prune origin"
#alias gprul="git fetch -p && for branch in `git branch -vv | grep ': gone]' | awk '{print $1}'`; do git branch -D $branch; done”
if [ -f ~/.bashrc ]; then
   source ~/.bashrc
fi
# install oh-my-zsh
export ZSH="/Users/kkanakam/.oh-my-zsh"
ZSH_THEME="agnoster"
ZSH_THEME_RANDOM_CANDIDATES=( "robbyrussell" "agnoster" )
plugins=(git docker)
source $ZSH/oh-my-zsh.sh

#export PS1='[\t] \u@\h \w $'
#export PS1='[\e[31m\t] \e[m \e[32m\u@\h\e[m \e[36m\w\e[m $'
test -e "${HOME}/.iterm2_shell_integration.bash" && source "${HOME}/.iterm2_shell_integration.bash"
