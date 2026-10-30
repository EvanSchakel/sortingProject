#!/usr/bin/env bash
set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PARENT_DIR="$(dirname "$SCRIPT_DIR")"
ARCHIVE_NAME="2500-Schakel, Evan.7z"
WRAPPER_DIR="2500-Schakel, Evan"

echo "============================================================"
echo "Compiling and validating Java project before packaging..."
echo "============================================================"

mkdir -p "$SCRIPT_DIR/bin"
javac -d "$SCRIPT_DIR/bin" "$SCRIPT_DIR/src/"*.java

echo "[OK] Compilation clean."

# Check for 7z command
if ! command -v 7z &> /dev/null; then
    echo "Error: 7z command not found. Please install via: brew install p7zip"
    exit 1
fi

TMP_DIR="/tmp/eecs2500_pkg_$$"
mkdir -p "$TMP_DIR/$WRAPPER_DIR"

echo "Staging files into $WRAPPER_DIR..."
# Copy source files, config, and README
cp -R "$SCRIPT_DIR/src" "$TMP_DIR/$WRAPPER_DIR/"
cp -R "$SCRIPT_DIR/bin" "$TMP_DIR/$WRAPPER_DIR/"
[ -d "$SCRIPT_DIR/.vscode" ] && cp -R "$SCRIPT_DIR/.vscode" "$TMP_DIR/$WRAPPER_DIR/"
[ -f "$SCRIPT_DIR/README.md" ] && cp "$SCRIPT_DIR/README.md" "$TMP_DIR/$WRAPPER_DIR/"

echo "Generating 7-Zip archive: $ARCHIVE_NAME..."
rm -f "$PARENT_DIR/$ARCHIVE_NAME" "$SCRIPT_DIR/$ARCHIVE_NAME"

(cd "$TMP_DIR" && 7z a -t7z -mx=9 "$SCRIPT_DIR/$ARCHIVE_NAME" "$WRAPPER_DIR" > /dev/null)
cp "$SCRIPT_DIR/$ARCHIVE_NAME" "$PARENT_DIR/$ARCHIVE_NAME"

rm -rf "$TMP_DIR"

echo "============================================================"
echo "[SUCCESS] Generated submission archive:"
echo "  -> $SCRIPT_DIR/$ARCHIVE_NAME"
echo "  -> $PARENT_DIR/$ARCHIVE_NAME"
echo "Ready for upload to Blackboard bucket: 'Upload 7Zip for Five Lists Here'"
echo "============================================================"
