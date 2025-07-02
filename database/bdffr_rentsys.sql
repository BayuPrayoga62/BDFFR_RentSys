-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 02 Jul 2025 pada 15.43
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bdffr_rentsys`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `costumer`
--

CREATE TABLE `costumer` (
  `id` int(10) UNSIGNED NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `no_hp` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `jenis_kelamin` enum('pria','wanita') DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `costumer`
--

INSERT INTO `costumer` (`id`, `nama`, `no_hp`, `email`, `alamat`, `jenis_kelamin`, `created_at`, `updated_at`) VALUES
(1, 'Jaka', '08977654', 'jaka@gmail.com', 'Jl. cinere, RT 3 RW 2, Kel. cinere, Kec. cinere, Depok', 'pria', '2025-06-21 02:53:27', '2025-06-21 02:53:27'),
(2, 'Dion', '0877921', 'dion@gmail.com', 'Jl. Kembangan, RT 3 RW 1, Kel. Kembangan, Kec. Kembangan, Jakarta Barat', 'pria', '2025-06-21 09:55:32', '2025-06-21 09:55:32'),
(3, 'abdur', '081200224411', 'abdur@gmail.com', 'Jl. merdeka, RT 5 RW 1, Kel. pondok cabe, Kec. pondok cabe, tangerang', 'pria', '2025-06-28 03:57:55', '2025-06-28 03:57:55'),
(4, 'Hendri', '081200441122', 'hendri@gmail.com', 'Jl. cirendeu raya, RT 6 RW 2, Kel. cirendeu, Kec. cirendeu, Tangerang Selatan', 'pria', '2025-06-28 04:37:24', '2025-06-28 04:37:24');

-- --------------------------------------------------------

--
-- Struktur dari tabel `mobil`
--

CREATE TABLE `mobil` (
  `id` int(10) UNSIGNED NOT NULL,
  `nama_mobil` varchar(20) DEFAULT NULL,
  `jenis` varchar(20) DEFAULT NULL,
  `nomor_kendaraan` varchar(10) DEFAULT NULL,
  `warna` varchar(10) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `status` varchar(50) NOT NULL,
  `harga` int(50) NOT NULL,
  `tahun` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `mobil`
--

INSERT INTO `mobil` (`id`, `nama_mobil`, `jenis`, `nomor_kendaraan`, `warna`, `created_at`, `updated_at`, `status`, `harga`, `tahun`) VALUES
(1, 'Honda', 'Mobilio', 'B 2021 AG', 'Putih', '2025-06-13 10:08:06', '2025-06-28 03:57:59', 'dipinjam', 500000, '2021'),
(3, 'Civic Turbo', 'Sedan', 'B 3441 CC', 'Merah', '2025-06-21 09:52:06', '2025-06-21 09:55:37', 'dipinjam', 800000, '2024'),
(4, 'Toyota Vios', 'Sedan', 'B 1209 KK', 'Merah', '2025-06-25 11:35:19', '2025-06-28 04:37:26', 'dipinjam', 700000, '2023'),
(5, 'Mitsubishi', 'Xpander', 'B 7777 MW', 'Hitam', '2025-06-28 03:53:10', '2025-06-28 03:53:10', 'tersedia', 799500, '2021');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id` int(10) UNSIGNED NOT NULL,
  `id_costumer` int(10) UNSIGNED DEFAULT NULL,
  `id_mobil` int(10) UNSIGNED DEFAULT NULL,
  `jumlah_sewa` int(10) DEFAULT NULL,
  `lama_hari_sewa` varchar(10) DEFAULT NULL,
  `total_harga_sewa` int(10) DEFAULT NULL,
  `jenis_transaksi` enum('tersedia','dipinjam','dikembalikan') DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id`, `id_costumer`, `id_mobil`, `jumlah_sewa`, `lama_hari_sewa`, `total_harga_sewa`, `jenis_transaksi`, `created_at`, `updated_at`) VALUES
(2, 2, 3, 1, '2', 1600000, 'dipinjam', '2025-06-20 17:00:00', '2025-06-22 17:00:00'),
(3, 3, 1, 1, '2', 1000000, 'dipinjam', '2025-06-27 17:00:00', '2025-06-29 17:00:00'),
(4, 4, 4, 1, '1', 700000, 'dipinjam', '2025-06-27 17:00:00', '2025-06-28 17:00:00');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id` int(10) UNSIGNED NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('admin','petugas') DEFAULT 'petugas',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `role`, `created_at`, `updated_at`) VALUES
(2, 'admin', '240be518fabd2724ddb6f04eeb1da5967448d7e831c08c8fa822809f74c720a9', 'admin', '2025-06-09 10:24:56', '2025-06-09 10:24:56'),
(5, 'petugas', '2dad904f71aa0dcf6ea1addaa084a5865ffe448e4d3f900668e1cc7e7b6153d7', 'petugas', '2025-06-27 11:47:51', '2025-06-27 11:47:51'),
(8, 'bayu', '414058c6f7fad3cad2dccd0ae8eb91f318617d36e5d9326e042db79703d13d10', 'admin', '2025-06-28 04:18:05', '2025-06-28 04:18:05'),
(9, 'ferdy', '1ebf236a36a3729ec8b9de29566bf74a9bb1a789a718bf82ced149d76e885876', 'petugas', '2025-06-28 04:18:17', '2025-06-28 04:18:17'),
(10, 'rafi', 'dd5d261e81f6abcab8a32e901c85dbcba409e482cd1c98a1e803d8ffb44e7cde', 'admin', '2025-06-28 04:18:34', '2025-06-28 04:18:34');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `costumer`
--
ALTER TABLE `costumer`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `mobil`
--
ALTER TABLE `mobil`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_costumer` (`id_costumer`),
  ADD KEY `id_mobil` (`id_mobil`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `costumer`
--
ALTER TABLE `costumer`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `mobil`
--
ALTER TABLE `mobil`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`id_costumer`) REFERENCES `costumer` (`id`),
  ADD CONSTRAINT `transaksi_ibfk_3` FOREIGN KEY (`id_mobil`) REFERENCES `mobil` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
