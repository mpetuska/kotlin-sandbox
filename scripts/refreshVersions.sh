#!/usr/bin/env bash

start="$(pwd)"
root="$(dirname "${BASH_SOURCE[0]}")/.."
root="$(cd "$root" && pwd)"

function refreshVersions() {
  "$root/gradlew" refreshVersions
}

targets=("build-conventions" "")
for t in "${targets[@]}"; do
  target="$root/$t"
  echo ">>> Refreshing $target"
  cd "$target" && refreshVersions
  status=$?
  if [[ $status -ne 0 ]]; then
    cd "$start" && echo ">>> FAILURE[$status]!"
    exit $status
  fi
done

cd "$start" && echo ">>> DONE!"
