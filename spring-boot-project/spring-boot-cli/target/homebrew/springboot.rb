require 'formula'

class Springboot < Formula
  homepage 'https://spring.io/projects/spring-boot'
  url 'https://repo.spring.io/snapshot/org/springframework/boot/spring-boot-cli/2.2.12.BUILD-SNAPSHOT/spring-boot-cli-2.2.12.BUILD-SNAPSHOT-bin.tar.gz'
  version '2.2.12.BUILD-SNAPSHOT'
  sha256 '8b6d39efd94592a727124cc6f7e3c576e9e4b3fbce4ef2b4b8db6d95927a6df9'
  head 'https://github.com/spring-projects/spring-boot.git'

  if build.head?
    depends_on 'maven' => :build
  end

  def install
    if build.head?
      Dir.chdir('spring-boot-cli') { system 'mvn -U -DskipTests=true package' }
      root = 'spring-boot-cli/target/spring-boot-cli-*-bin/spring-*'
    else
      root = '.'
    end

    bin.install Dir["#{root}/bin/spring"]
    lib.install Dir["#{root}/lib/spring-boot-cli-*.jar"]
    bash_completion.install Dir["#{root}/shell-completion/bash/spring"]
    zsh_completion.install Dir["#{root}/shell-completion/zsh/_spring"]
  end
end
