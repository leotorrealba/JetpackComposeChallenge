# Color Picker App

A modern, intuitive RGB color picker built with Jetpack Compose.

## Features

- Real-time RGB color mixing with interactive sliders
- Live color preview with adaptive text
- Hex code display with one-tap copy functionality
- Material 3 design with light/dark theme support
- Smooth animations and transitions
- Responsive layout for all screen sizes

## Project Structure

```
app/
├── models/
│   └── ColorModel.kt            # Data model for RGB color values
├── ui/
│   ├── components/
│   │   ├── AppBar.kt            # Top app bar component
│   │   ├── ColorPreview.kt      # Color preview display
│   │   ├── ColorSlider.kt       # RGB slider component
│   │   └── HexCodeDisplay.kt    # Hex code display with copy button
│   ├── navigation/
│   │   └── NavGraph.kt          # Navigation configuration
│   ├── screens/
│   │   └── ColorPickerScreen.kt # Main screen composition
│   └── theme/
│       ├── Theme.kt             # Material 3 theme configuration
│       ├── Type.kt              # Typography definitions
│       └── Shape.kt             # Shape definitions
└── viewmodels/
    └── ColorPickerViewModel.kt  # ViewModel for state management
```

## Architecture

This app follows the MVVM (Model-View-ViewModel) architecture pattern:

- **Model**: Simple data class representing RGB color values
- **View**: Composable UI components that display the color and controls
- **ViewModel**: Manages UI state and handles user interactions

## Technical Details

### Key Technologies

- **Jetpack Compose**: Modern declarative UI toolkit
- **Material 3**: Latest Material Design components and theming
- **ViewModel**: Lifecycle-aware state management
- **Animations**: Compose animation APIs for smooth transitions
- **Kotlin Coroutines**: For asynchronous operations

### Implementation Highlights

#### Color Conversion

```kotlin
data class ColorModel(
    val red: Int = 0,
    val green: Int = 0,
    val blue: Int = 0
) {
    fun toHexString(): String {
        return String.format("#%02X%02X%02X", red, green, blue)
    }
}
```

#### Animated Color Preview

```kotlin
val animatedColor by animateColorAsState(targetValue = color, label = "")

Box(
    modifier = Modifier
        .background(animatedColor)
        .fillMaxWidth()
        .aspectRatio(1.5f)
)
```

#### Interactive RGB Sliders

```kotlin
ColorSlider(
    value = colorState.red,
    onValueChange = { viewModel.updateRed(it) },
    label = "Red",
    color = Color.Red
)
```

## Getting Started

### Prerequisites

- Android Studio Arctic Fox or newer
- Android SDK 21+
- Kotlin 1.5.0+

### Installation

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/color-picker.git
   ```

2. Open the project in Android Studio

3. Build and run the app on an emulator or physical device

## Usage

1. Adjust the RGB sliders to mix your desired color
2. View the real-time color preview
3. Copy the hex code with a single tap for use in your designs

## Customization

The app can be easily customized:

- Modify the `Theme.kt` file to change the app's color scheme
- Add additional color models (HSL, CMYK) by extending the `ColorModel` class
- Implement color palettes or favorites by extending the ViewModel

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- Material Design guidelines for UI/UX inspiration
- Jetpack Compose documentation and codelabs

---

## Future Enhancements

- Color history tracking
- Color palette generation
- Export colors to design tools
- Color accessibility information (WCAG contrast)
- Additional color models (HSL, CMYK)

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request
