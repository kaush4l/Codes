# Installing zsh terminal
sudo apt-get install zsh

# Just to see the installation location of zsh terminal
# which zsh

# Changing the deafult shell to zsh
chsh -s $(which zsh)

# Restart shell at this point to get the select the new settings

# Installing oh-my-zsh
# zsh configuration manager on top of zsh
sh -c "$(curl -fsSL https://raw.githubusercontent.com/robbyrussell/oh-my-zsh/master/tools/install.sh)"

# usually config file is located at root => ~/.zshrc
# Change the theme name of install new themes and use them as directed

# 1) Clone any zsh theme configuration into machine
# Usually cloned to ~/.oh-my-zsh/themes and plugins to ~/.oh-my-zsh/plugins
# 2) Copy the new configuration to the .zshrc or just point the configuration to the new file

# Powerlevel10k
git clone --depth=1 https://github.com/romkatv/powerlevel10k.git ${ZSH_CUSTOM:-$HOME/.oh-my-zsh/custom}/themes/powerlevel10k

# Set ZSH_THEME="powerlevel10k/powerlevel10k" in ~/.zshrc

# Restart terminal again to access and apply the new settings or run ```p10k configure```
