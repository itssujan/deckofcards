.PONY: all build test

all: build

clean:
	rm -rf build

build:
	@./gradlew assemble --warning-mode all

test:
	@./gradlew check --warning-mode all
