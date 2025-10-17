#!/usr/bin/env bash
set -euo pipefail

# Build and install the application distribution (includes all runtime deps)
./gradlew --quiet --no-daemon installDist

# Run the generated start script so the classpath includes dependencies
exec ./build/install/techbite/bin/techbite "$@"

